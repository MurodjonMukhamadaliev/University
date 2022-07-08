package uz.murodjon.university.service.journal;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.journal.JournalCreateDTO;
import uz.murodjon.university.dto.journal.JournalDTO;
import uz.murodjon.university.dto.journal.JournalUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.Group;
import uz.murodjon.university.entity.Journal;
import uz.murodjon.university.entity.University;
import uz.murodjon.university.exception.AlreadyExistsException;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.JournalMapper;
import uz.murodjon.university.mapper.SubjectMapper;
import uz.murodjon.university.repository.GroupRepository;
import uz.murodjon.university.repository.JournalRepository;
import uz.murodjon.university.service.AbstractService;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl extends AbstractService<JournalRepository, JournalMapper> implements JournalService {
    protected final GroupRepository groupRepository;
    private final SubjectMapper subjectMapper;

    public JournalServiceImpl(JournalRepository repository, JournalMapper mapper, GroupRepository groupRepository, SubjectMapper subjectMapper) {
        super(repository, mapper);
        this.groupRepository = groupRepository;
        this.subjectMapper = subjectMapper;
    }
    @Cacheable(value = "journal")
    @Override
    public DataDTO<JournalDTO> create(JournalCreateDTO createDto) {
        Group group = groupRepository.findByIdAndDeletedFalse(createDto.getGroupId()).orElseThrow(
                () -> new NotFoundException("Group not found", Group.class, "groupId"));
        if (group.getJournal() != null && !group.getJournal().isDeleted()) {
            throw new AlreadyExistsException("Journal exists!", Journal.class, "journalId");
        }
        Journal journal = mapper.fromCreateDto(createDto);
        journal.setGroup(group);
        JournalDTO journalDTO = mapper.toDto(repository.save(journal));
        journalDTO.setGroupName(group.getName());
        return new DataDTO<>(journalDTO);
    }
    @CachePut(value = "journal")
    @Override
    public DataDTO<JournalDTO> update(JournalUpdateDTO updateDto) {
        Journal journal = repository.findByIdAndDeletedFalse(updateDto.getId()).orElseThrow(
                () -> new NotFoundException("Journal not found", Journal.class, "journalId"));
        if (updateDto.getName() != null)
            journal.setName(updateDto.getName());
        JournalDTO journalDTO = mapper.toDto(repository.save(journal));
        return new DataDTO<>(journalDTO);
    }
    @Cacheable(value = "journal")
    @Override
    public DataDTO<JournalDTO> get(Long id) {
        Journal journal = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Journal not found", Journal.class, "journalId"));
        JournalDTO journalDTO = mapper.toDto(journal);
        journalDTO.setGroupName(journal.getGroup().getName());
        return new DataDTO<>(journalDTO);
    }

    @Override
    public DataDTO<List<JournalDTO>> getAll() {
        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalse()));
    }
    @CacheEvict(value = "journal")
    @Override
    public DataDTO<Void> delete(Long id) {
        Journal journal = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Journal not found", Journal.class, "journalId"));
        journal.setDeleted(true);
        repository.save(journal);
        return new DataDTO<>(true);
    }
}
