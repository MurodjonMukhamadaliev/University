package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.mark.MarkCreateDTO;
import uz.murodjon.university.dto.mark.MarkDTO;
import uz.murodjon.university.dto.mark.MarkUpdateDTO;
import uz.murodjon.university.entity.Mark;

@Component
@Mapper(componentModel = "spring")
public interface MarkMapper extends GenericMapper<Mark, MarkDTO, MarkCreateDTO, MarkUpdateDTO, Long> {
}