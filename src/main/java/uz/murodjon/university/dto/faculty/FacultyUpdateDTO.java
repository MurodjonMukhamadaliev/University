package uz.murodjon.university.dto.faculty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyUpdateDTO extends GenericDTO {
    private String name;

    private int openYear;
}
