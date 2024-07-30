package io.github.rvdxk.mapper;

import io.github.rvdxk.dto.UserDto;
import io.github.rvdxk.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userCar(user.getUserCar())
                .build();
    }
}
