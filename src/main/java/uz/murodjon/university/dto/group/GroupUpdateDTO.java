package uz.murodjon.university.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupUpdateDTO extends GenericDTO {
    private String name;
}
