package uz.murodjon.university.dto.mark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.murodjon.university.dto.BaseDTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateDTO implements BaseDTO {
    @Min(value = 3, message = "Min mark must be 3")
    @Max(value = 5, message = "max mark must be 5")
    private int mark;
    @NotNull
    private Long studentId;

}
