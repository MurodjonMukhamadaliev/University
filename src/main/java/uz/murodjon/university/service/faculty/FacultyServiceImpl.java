package uz.murodjon.university.service.faculty;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.faculty.FacultyCreateDTO;
import uz.murodjon.university.dto.faculty.FacultyDTO;
import uz.murodjon.university.dto.faculty.FacultyUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.Faculty;
import uz.murodjon.university.entity.Group;
import uz.murodjon.university.entity.University;
import uz.murodjon.university.exception.AlreadyExistsException;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.FacultyMapper;
import uz.murodjon.university.repository.FacultyRepository;
import uz.murodjon.university.repository.UniversityRepo;
import uz.murodjon.university.service.AbstractService;
import uz.murodjon.university.service.group.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl extends AbstractService<FacultyRepository, FacultyMapper> implements FacultyService {
    private final UniversityRepo universityRepo;
    private final GroupService groupService;

    public FacultyServiceImpl(FacultyRepository repository, FacultyMapper mapper, UniversityRepo universityRepo, GroupService groupService) {
        super(repository, mapper);
        this.universityRepo = universityRepo;
        this.groupService = groupService;
    }

    @Cacheable(value = "faculty")
    @Override
    public DataDTO<FacultyDTO> create(FacultyCreateDTO createDto) {
        University university = universityRepo.findByIdAndDeletedFalse(createDto.getUniversityId()).orElseThrow(
                () -> new NotFoundException("University not found!", University.class, "universityId"));
        if (repository.existsByNameAndUniversityId(createDto.getName(), createDto.getUniversityId()))
            throw new AlreadyExistsException("Faculty already exists", Faculty.class, "facultyId");
        Faculty faculty = mapper.fromCreateDto(createDto);
        faculty.setUniversity(university);
        FacultyDTO facultyDTO = mapper.toDto(repository.save(faculty));
        facultyDTO.setUniversityName(faculty.getUniversity().getName());
        return new DataDTO<>(facultyDTO);
    }

    @CachePut(value = "faculty")
    @Override
    public DataDTO<FacultyDTO> update(FacultyUpdateDTO updateDto) {
        Faculty faculty = repository.findByIdAndDeletedFalse(updateDto.getId()).orElseThrow(
                () -> new NotFoundException("Faculty not found!", Faculty.class, "facultyId"));
        if (repository.existsByNameAndUniversity(updateDto.getName(), faculty.getUniversity()))
            throw new AlreadyExistsException("Faculty already exists!", Faculty.class, "facultyId");
        if (updateDto.getName() != null)
            faculty.setName(updateDto.getName());
        FacultyDTO facultyDTO = mapper.toDto(repository.save(faculty));
        facultyDTO.setUniversityName(faculty.getUniversity().getName());
        return new DataDTO<>(facultyDTO);
    }

    @Cacheable(value = "faculty")
    @Override
    public DataDTO<FacultyDTO> get(Long id) {
        Faculty faculty = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Faculty not found!", Faculty.class, "facultyId"));
        FacultyDTO facultyDTO = mapper.toDto(faculty);
        facultyDTO.setUniversityName(faculty.getUniversity().getName());
        return new DataDTO<>(facultyDTO);
    }

    @Override
    public DataDTO<List<FacultyDTO>> getAll() {
        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalse()));
    }

    @Override
    public DataDTO<List<FacultyDTO>> getAllByUniversityId(Long id) {
        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalseAndUniversityId(id)));
    }

    @CacheEvict(value = "faculty")
    @Override
    public DataDTO<Void> delete(Long id) {
        Faculty faculty = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Faculty not found!", Faculty.class, "facultyId"));
        faculty.setDeleted(true);
        faculty.getGroups().stream().forEach(group -> group.setDeleted(true));
        repository.save(faculty);
        return new DataDTO<>(true);
    }
}
