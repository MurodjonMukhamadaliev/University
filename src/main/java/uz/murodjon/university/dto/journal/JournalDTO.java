package uz.murodjon.university.dto.journal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.GenericDTO;
import uz.murodjon.university.dto.subject.SubjectDTO;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JournalDTO extends GenericDTO {
    private String name;
    private String groupName;
//    private List<SubjectDTO> subjectDTOs;
}
