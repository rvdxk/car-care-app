package io.github.rvdxk.service.impl;

import io.github.rvdxk.dto.UserDto;
import io.github.rvdxk.entity.User;
import io.github.rvdxk.exception.ResourceNotFoundException;
import io.github.rvdxk.mapper.UserMapper;
import io.github.rvdxk.repository.UserRepository;
import io.github.rvdxk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto findUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream()
                .map((user) -> UserMapper.mapToUserDto(user)).toList();

        return userDtoList;
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        userRepository.deleteById(id);
    }
}
