package com.irq3.infrastructure.servicesImpl;

import com.irq3.domain.models.User;
import com.irq3.domain.models.dto.UserCreate;
import com.irq3.domain.models.dto.UserDto;
import com.irq3.domain.models.dto.UserUpdate;
import com.irq3.domain.services.UserService;
import com.irq3.infrastructure.repositories.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject UserRepository userRepository;

    @Override public void createUser(UserCreate create) {
        User user = User.create(create.name(),create.email(),create.password());
        if(userRepository.existsByEmail(user.getEmail()) || userRepository.existsByName(user.getName())){
            throw new RuntimeException("User with this name/mail exists");
        }
        user.hashPassword();

        userRepository.save(user);
    }

    @Override public UserDto getUserById(long id) {
        return null;
    }

    @Override public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override public UserDto updateUser(UserUpdate userUpdate) {
        return null;
    }

    @Override public String deleteUser(long id) {
        return "";
    }

    @Override public String deleteUser(String email) {
        return "";
    }
}
