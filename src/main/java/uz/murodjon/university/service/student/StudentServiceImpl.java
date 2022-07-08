package uz.murodjon.university.service.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.student.StudentCreateDTO;
import uz.murodjon.university.dto.student.StudentDTO;
import uz.murodjon.university.dto.student.StudentUpdateDTO;
import uz.murodjon.university.dto.subject.SubjectDTO;
import uz.murodjon.university.entity.Group;
import uz.murodjon.university.entity.Student;
import uz.murodjon.university.entity.University;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.StudentMapper;
import uz.murodjon.university.mapper.SubjectMapper;
import uz.murodjon.university.repository.GroupRepository;
import uz.murodjon.university.repository.StudentRepository;
import uz.murodjon.university.service.AbstractService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl extends AbstractService<StudentRepository, StudentMapper> implements StudentService {
    private final GroupRepository groupRepository;
    private final SubjectMapper subjectMapper;

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper, GroupRepository groupRepository, SubjectMapper subjectMapper) {
        super(repository, mapper);
        this.groupRepository = groupRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public DataDTO<StudentDTO> create(StudentCreateDTO createDto) {
        Group group = groupRepository.findByIdAndDeletedFalse(createDto.getGroupId()).orElseThrow(
                () -> new NotFoundException("Group not found", Group.class, "groupId"));
        Student student = mapper.fromCreateDto(createDto);
        student.setGroup(group);
        StudentDTO studentDTO = mapper.toDto(repository.save(student));
        studentDTO.setGroupName(group.getName());
        return new DataDTO<>(studentDTO);
    }


    @Override
    public DataDTO<StudentDTO> update(StudentUpdateDTO updateDto) {
        Student student = repository.findByIdAndDeletedFalse(updateDto.getId()).orElseThrow(
                () -> new NotFoundException("Student not found", Student.class, "studentId"));

        Group group = groupRepository.findByIdAndDeletedFalse(updateDto.getGroupId()).orElseThrow(
                () -> new NotFoundException("Group not found", Group.class, "groupId"));
        if (updateDto.getGroupId() != null && !Objects.equals(updateDto.getGroupId(), student.getGroup().getId()))
            student.setGroup(group);
        if (updateDto.getAddress() != null) student.setAddress(updateDto.getAddress());
        if (updateDto.getFirstName() != null) student.setEmail(updateDto.getEmail());
        if (updateDto.getLastName() != null) student.setLastName(updateDto.getLastName());
        if (updateDto.getPhone() != null) student.setPhone(updateDto.getPhone());
        StudentDTO studentDTO = mapper.toDto(repository.save(student));
        studentDTO.setGroupName(group.getName());
        return new DataDTO<>(studentDTO);
    }


    @Override
    public DataDTO<StudentDTO> get(Long id) {
        Student student = repository.findById(id).orElseThrow(
                () -> new NotFoundException("University not found", University.class, "universityID"));
        return new DataDTO<>(mapper.toDto(student));
    }

    @Override
    public DataDTO<List<StudentDTO>> getAll() {

        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalse()));
    }

    @Override
    public DataDTO<Void> delete(Long id) {
        Student student = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Student not found", Student.class, "studentId"));
        student.setDeleted(true);
        repository.save(student);
        return new DataDTO<>(true);
    }

}
