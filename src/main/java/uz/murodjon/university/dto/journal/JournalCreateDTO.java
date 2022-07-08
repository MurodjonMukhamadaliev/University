package uz.murodjon.university.dto.journal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.BaseDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JournalCreateDTO implements BaseDTO {
    private String name;
    private Long groupId;
}
