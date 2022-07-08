package uz.murodjon.university.dto.mark;

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
public class MarkDTO extends GenericDTO {
    private int mark;
    private String date;
    private String studentName;
    private String groupName;
}