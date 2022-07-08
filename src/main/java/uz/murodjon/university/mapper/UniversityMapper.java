package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.university.UniversityDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.entity.University;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UniversityMapper extends GenericMapper<University, UniversityDTO, UniversityCreateDTO, UniversityUpdateDTO, Number> {

    @Override
    UniversityDTO toDto(University university);

    @Override
    List<UniversityDTO> toDto(List<University> e);

    @Override
    University fromCreateDto(UniversityCreateDTO universityCreateDTO);

    @Override
    University fromUpdateDto(UniversityUpdateDTO d);
}