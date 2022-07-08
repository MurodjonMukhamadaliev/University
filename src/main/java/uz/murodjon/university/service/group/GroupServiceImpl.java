package uz.murodjon.university.service.group;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.group.GroupCreateDTO;
import uz.murodjon.university.dto.group.GroupDTO;
import uz.murodjon.university.dto.group.GroupUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.student.StudentsMark;
import uz.murodjon.university.entity.Faculty;
import uz.murodjon.university.entity.Group;
import uz.murodjon.university.entity.Student;
import uz.murodjon.university.exception.AlreadyExistsException;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.GroupMapper;
import uz.murodjon.university.repository.FacultyRepository;
import uz.murodjon.university.repository.GroupRepository;
import uz.murodjon.university.repository.SubjectRepository;
import uz.murodjon.university.service.AbstractService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl extends AbstractService<GroupRepository, GroupMapper> implements GroupService {
    private final FacultyRepository facultyRepository;

    private final SubjectRepository subjectRepository;

    public GroupServiceImpl(GroupRepository repository, GroupMapper mapper, FacultyRepository facultyRepository, SubjectRepository subjectRepository) {
        super(repository, mapper);
        this.facultyRepository = facultyRepository;
        this.subjectRepository = subjectRepository;
    }
    @Cacheable(value = "group")
    @Override
    public DataDTO<GroupDTO> create(GroupCreateDTO createDto) {
        Faculty faculty = facultyRepository.findByIdAndDeletedFalse(createDto.getFacultyId()).orElseThrow(
                () -> new NotFoundException("Faculty not found!", Faculty.class, "facultyId"));

        if (repository.existsByNameAndFaculty(createDto.getName(), faculty))
            throw new AlreadyExistsException("Group already exists!", Group.class, "groupId");
        Group group = mapper.fromCreateDto(createDto);
        group.setFaculty(faculty);
        GroupDTO groupDTO = mapper.toDto(repository.save(group));
        groupDTO.setFacultyName(faculty.getName());
        return new DataDTO<>(groupDTO);
    }

    @CachePut(value = "group")
    @Override
    public DataDTO<GroupDTO> update(GroupUpdateDTO updateDto) {
        Group group = repository.findByIdAndDeletedFalse(updateDto.getId()).orElseThrow(
                () -> new NotFoundException("Group not found!", Group.class, "groupId"));
        if (repository.existsByNameAndFaculty(updateDto.getName(), group.getFaculty()))
            throw new AlreadyExistsException("Group already exists!", Group.class, "groupId");

        if (updateDto.getName() != null)
            group.setName(updateDto.getName());
        GroupDTO groupDTO = mapper.toDto(repository.save(group));
        groupDTO.setFacultyName(group.getFaculty().getName());
        return new DataDTO<>(groupDTO);
    }
    @Cacheable(value = "group")
    @Override
    public DataDTO<GroupDTO> get(Long id) {
        Group group = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Group not found!", Group.class, "groupId"));
        GroupDTO groupDTO = mapper.toDto(group);
        groupDTO.setStudentCount(group.getStudents().size());
        groupDTO.setFacultyName(group.getFaculty().getName());
        return new DataDTO<>(groupDTO);
    }

    @Override
    public DataDTO<List<GroupDTO>> getAll() {
        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalseOrderById()));
    }
    @CacheEvict(value = "group")
    @Override
    public DataDTO<Void> delete(Long id) {
        Group group = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Group not found!", Group.class, "groupId"));
        group.setDeleted(true);
        group.getStudents().forEach(student -> student.setDeleted(true));
        repository.save(group);
        return new DataDTO<>(true);
    }

    @Override
    public DataDTO<List<GroupDTO>> getAllByFacultyId(Long id) {
        return new DataDTO<>(mapper.toDto(repository.findAllByFacultyIdAndDeletedFalse(id)));
    }

    @Override
    public DataDTO<?> getMarkStudent(Long id) {
        List<StudentsMark> studentsMarks = repository.groupStudentsMark(id);
        return new DataDTO<>(studentsMarks);
    }
}
