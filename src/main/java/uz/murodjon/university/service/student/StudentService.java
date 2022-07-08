package uz.murodjon.university.service.student;

import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.student.StudentCreateDTO;
import uz.murodjon.university.dto.student.StudentDTO;
import uz.murodjon.university.dto.student.StudentUpdateDTO;
import uz.murodjon.university.dto.subject.SubjectDTO;
import uz.murodjon.university.entity.Student;
import uz.murodjon.university.service.GenericCrudService;

import java.util.List;

public interface StudentService extends GenericCrudService<Student, StudentDTO, StudentCreateDTO, StudentUpdateDTO, Long> {
}