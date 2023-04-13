package org.johny7guitar.supersecretusersdb.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.johny7guitar.supersecretusersdb.entities.UserStatus;
import org.johny7guitar.supersecretusersdb.services.UserService;
import org.johny7guitar.supersecretusersdb.util.UserMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private static final ObjectMapper json = new ObjectMapper();

    private static UserDto validUser;
    private static UserDto invalidUser;

    @BeforeAll
    static void init(){
        validUser = new UserDto(-1, "test", "test@protonmail.com", "", UserStatus.ONLINE);
        invalidUser = new UserDto(-1, "", "123", "10", UserStatus.ONLINE);
    }

    @Test @Order(0)
    void testAddUser() throws Exception{

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.writeValueAsString(validUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value("1"));

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.writeValueAsString(invalidUser)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors", hasSize(4)))
                .andExpect(jsonPath("$.errors[*].field", containsInAnyOrder("username", "username", "email", "userpic")));

    }

    @Test @Order(1)
    void testGetUser() throws Exception{

        mockMvc.perform(get("/users/1")).andExpect(status().isNotFound());

        assertDoesNotThrow(() -> userService.addUser(UserMapper.INSTANCE.userDtoToUser(validUser)));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.username", is(validUser.getUsername())))
                .andExpect(jsonPath("$.user.userpic", is(validUser.getUserpic())))
                .andExpect(jsonPath("$.user.email", is(validUser.getEmail())))
                .andExpect(jsonPath("$.user.userStatus", equalToIgnoringCase(validUser.getUserStatus().toString())));

    }

    @Test @Order(2)
    void statusUpdateTest() throws Exception{

        mockMvc.perform(patch("/users/1/update_status/offline")).andExpect(status().isNotFound());

        UserStatus oldUserStatus = validUser.getUserStatus();
        assertDoesNotThrow(() -> userService.addUser(UserMapper.INSTANCE.userDtoToUser(validUser)));

        mockMvc.perform(patch("/users/1/update_status/offline"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(1)))
                .andExpect(jsonPath("$.old_status", equalToIgnoringCase(oldUserStatus.toString())))
                .andExpect(jsonPath("$.new_status", equalToIgnoringCase("offline")));

    }

}