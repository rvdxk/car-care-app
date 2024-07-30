package io.github.rvdxk.service;

import io.github.rvdxk.dto.UserDto;
import io.github.rvdxk.entity.User;

import java.util.List;

public interface UserService {
    UserDto findUserById(Long id);
    List<UserDto> getAllUsers();
    void deleteUser(Long id);
}
