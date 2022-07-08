package uz.murodjon.university.dto.university;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityUpdateDTO extends GenericDTO {
    private String name;
    private String address;
    private int openYear;
}
