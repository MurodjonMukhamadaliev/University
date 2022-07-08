package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.subject.SubjectCreateDTO;
import uz.murodjon.university.dto.subject.SubjectDTO;
import uz.murodjon.university.dto.subject.SubjectUpdateDTO;
import uz.murodjon.university.entity.Subject;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericMapper<Subject, SubjectDTO, SubjectCreateDTO, SubjectUpdateDTO, Long> {

    @Override
    SubjectDTO toDto(Subject subject);

    @Override
    List<SubjectDTO> toDto(List<Subject> e);

    @Override
    Subject fromCreateDto(SubjectCreateDTO subjectCreateDTO);

    @Override
    Subject fromUpdateDto(SubjectUpdateDTO d);
}
