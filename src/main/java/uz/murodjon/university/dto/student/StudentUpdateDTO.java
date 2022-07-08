package uz.murodjon.university.dto.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentUpdateDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Long groupId;
}
