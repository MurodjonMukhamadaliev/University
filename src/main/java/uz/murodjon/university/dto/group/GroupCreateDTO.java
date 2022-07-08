package uz.murodjon.university.dto.group;

import com.sun.istack.NotNull;
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
public class GroupCreateDTO implements BaseDTO {
    @NotBlank(message = "group name can't be null or empty")
    private String name;
    @NotNull
    private Long facultyId;

}
