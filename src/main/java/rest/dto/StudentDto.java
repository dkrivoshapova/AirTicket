package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

//import javax.validation.*

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String id;

    private String number;

    @Email(message = "Email должен быть корректным адресом электронной почты")
    private String name;
    
    private String birthDate;

}
