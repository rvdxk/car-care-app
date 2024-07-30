package io.github.rvdxk.dto;

import io.github.rvdxk.entity.UserCar;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "Please, enter the first name.")
    private String firstName;

    @NotBlank(message = "Please, enter the last name.")
    private String lastName;

    @NotNull(message = "Please, enter the information about your car.")
    private UserCar userCar;

    //bedzie uzyte np do umowienia wizyty u mechanika
}
