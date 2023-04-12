package org.johny7guitar.supersecretusersdb.services;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.exception.EntityNotFoundException;
import org.johny7guitar.supersecretusersdb.repository.UserRepository;
import org.johny7guitar.supersecretusersdb.util.UserMapper;
import org.johny7guitar.supersecretusersdb.web.UserStatusChangeDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest{

    @Mock
    private static UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private static final User testUser = new User(12, "ramanavich", "ramanavich@dmail.com", URI.create(""));

    @Test
    void addUserTest(){

        assertNotNull(userService);

        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(testUser);

        AtomicReference<User> savedUser = new AtomicReference<>();
        assertDoesNotThrow(() -> savedUser.set(userService.addUser(testUser)));

        assertNotNull(savedUser.get());
        verify(userRepository).save(testUser);

    }

    @Test
    void addExistingUserTest(){

        assertNotNull(userService);

        User newUser = new User(
                testUser.getId(),
                "test",
                "test",
                null
        );

        when(userRepository.findById(newUser.getId())).thenReturn(Optional.of(testUser));

        assertEquals(testUser, userService.addUser(newUser));

        verify(userRepository, never()).save(newUser);

    }

    @Test
    void updateUserStatusTest(){

        assertNotNull(userService);

        when(userRepository.findById(testUser.getId())).thenReturn(Optional.of(testUser));
        when(userRepository.findById(not(eq(testUser.getId())))).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        AtomicReference<UserStatusChangeDto> updateResult = new AtomicReference<>();
        assertThrows(EntityNotFoundException.class, () -> userService.updateUserStatus(-1, UserStatus.OFFLINE));
        assertDoesNotThrow(() -> updateResult.set(userService.updateUserStatus(testUser.getId(), UserStatus.OFFLINE)));

        assertNotNull(updateResult.get());
        assertEquals(testUser.getId(), updateResult.get().getUserId());
        assertEquals(UserStatus.OFFLINE, updateResult.get().getNewUserStatus());
        assertEquals(UserStatus.ONLINE, updateResult.get().getOldUserStatus());

    }

    @Test
    void getUserTest(){

        when(userRepository.findById(testUser.getId())).thenReturn(Optional.of(testUser));
        when(userRepository.findById(not(eq(testUser.getId())))).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.getUser(13L));
        assertEquals(testUser, UserMapper.INSTANCE.userDtoToUser(userService.getUser(testUser.getId())));

    }

}