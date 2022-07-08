package uz.murodjon.university.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.BaseDTO;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDTO implements BaseDTO {
    @NotBlank
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Long groupId;
}
