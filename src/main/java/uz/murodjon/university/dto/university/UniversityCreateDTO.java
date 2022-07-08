package uz.murodjon.university.dto.university;

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
public class UniversityCreateDTO implements BaseDTO {

    @NotBlank(message = "university name can't be null or empty")
    private String name;

    @NotBlank(message = "university address can't be null or empty")
    private String address;

    private int openYear;
}
