package uz.murodjon.university.dto.mark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkUpdateDTO extends GenericDTO {
    private int mark;
}
