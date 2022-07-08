package uz.murodjon.university.service.mark;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.mark.MarkCreateDTO;
import uz.murodjon.university.dto.mark.MarkDTO;
import uz.murodjon.university.dto.mark.MarkUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.Journal;
import uz.murodjon.university.entity.Mark;
import uz.murodjon.university.entity.Student;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.MarkMapper;
import uz.murodjon.university.repository.JournalRepository;
import uz.murodjon.university.repository.MarkRepository;
import uz.murodjon.university.repository.StudentRepository;
import uz.murodjon.university.service.AbstractService;

import java.util.List;

@Service
public class MarkServiceImpl extends AbstractService<MarkRepository, MarkMapper> implements MarkService {
    private final StudentRepository studentRepository;
    private final JournalRepository journalRepository;

    public MarkServiceImpl(MarkRepository repository, MarkMapper mapper, StudentRepository studentRepository, JournalRepository journalRepository) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
        this.journalRepository = journalRepository;
    }

    @Cacheable(value = "mark")
    @Override
    public DataDTO<MarkDTO> create(MarkCreateDTO createDto) {
        Student student = studentRepository.findByIdAndDeletedFalse(createDto.getStudentId()).orElseThrow(
                () -> new NotFoundException("Student not found", Student.class, "studentid"));
        Journal journal = journalRepository.findByIdAndDeletedFalse(student.getGroup().getJournal().getId()).orElseThrow(
                () -> new NotFoundException("Journal not found", Journal.class, "journalId"));
        Mark mark = mapper.fromCreateDto(createDto);
        mark.setJournal(journal);
        mark.setStudent(student);
        MarkDTO markDTO = mapper.toDto(repository.save(mark));
        markDTO.setGroupName(student.getGroup().getName());
        markDTO.setStudentName(student.getFirstName());
        return new DataDTO<>(markDTO);
    }

    @CacheEvict(value = "mark")
    @Override
    public DataDTO<Void> delete(Long id) {
        repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Mark not found", Mark.class, "markId"));
        return new DataDTO<>(true);
    }

    @CachePut(value = "mark")
    @Override
    public DataDTO<MarkDTO> update(MarkUpdateDTO updateDto) {
        return null;
    }

    @Override
    public DataDTO<List<MarkDTO>> getAll() {
        return new DataDTO<>(mapper.toDto(repository.findAll()));
    }

    @Cacheable(value = "mark")
    @Override
    public DataDTO<MarkDTO> get(Long id) {
        Mark mark = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Mark not found", Mark.class, "markId"));
        return new DataDTO<>(mapper.toDto(mark));
    }
}
