package org.johny7guitar.supersecretusersdb.repository;

import org.johny7guitar.supersecretusersdb.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
}
