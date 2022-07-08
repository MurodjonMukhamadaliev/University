package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.faculty.FacultyCreateDTO;
import uz.murodjon.university.dto.faculty.FacultyDTO;
import uz.murodjon.university.dto.faculty.FacultyUpdateDTO;
import uz.murodjon.university.entity.Faculty;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface FacultyMapper extends GenericMapper<Faculty, FacultyDTO, FacultyCreateDTO, FacultyUpdateDTO, Number> {
    @Override
    FacultyDTO toDto(Faculty faculty);

    @Override
    List<FacultyDTO> toDto(List<Faculty> e);

    @Override
    Faculty fromCreateDto(FacultyCreateDTO facultyCreateDTO);

    @Override
    Faculty fromUpdateDto(FacultyUpdateDTO d);
}