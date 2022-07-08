package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.student.StudentCreateDTO;
import uz.murodjon.university.dto.student.StudentDTO;
import uz.murodjon.university.dto.student.StudentUpdateDTO;
import uz.murodjon.university.entity.Student;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<Student, StudentDTO, StudentCreateDTO, StudentUpdateDTO, Long> {
}