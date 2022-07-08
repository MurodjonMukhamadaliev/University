package uz.murodjon.university.dto.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectUpdateDTO extends GenericDTO {
    private String name;
    private String description;

}
