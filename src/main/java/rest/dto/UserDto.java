package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

//import javax.validation.*

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;

    @Email(message = "Email должен быть корректным адресом электронной почты")
    private String email;

    private String password;

}
