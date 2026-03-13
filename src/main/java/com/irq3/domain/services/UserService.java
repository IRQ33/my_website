package com.irq3.domain.services;

import com.irq3.domain.models.dto.UserCreate;
import com.irq3.domain.models.dto.UserDto;
import com.irq3.domain.models.dto.UserUpdate;

public interface UserService {
    void createUser(UserCreate create);
    UserDto getUserById(long id);
    UserDto getUserByEmail(String email);
    UserDto updateUser(UserUpdate userUpdate);
    String deleteUser(long id);
    String deleteUser(String email);

}
