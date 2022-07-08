package uz.murodjon.university.dto.faculty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyCreateDTO implements BaseDTO {
    @NotBlank(message = "university name can't be null or empty")
    private String name;
    @NotNull
    private Long universityId;
    @NotNull
    private int openYear;
}
