package uz.murodjon.university.service.university;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.university.UniversityDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.entity.University;
import uz.murodjon.university.exception.AlreadyExistsException;
import uz.murodjon.university.exception.BadRequestException;
import uz.murodjon.university.exception.NotFoundException;
import uz.murodjon.university.mapper.UniversityMapper;
import uz.murodjon.university.repository.UniversityRepo;
import uz.murodjon.university.service.AbstractService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl extends AbstractService<UniversityRepo, UniversityMapper> implements UniversityService {

    public UniversityServiceImpl(UniversityRepo repository, UniversityMapper mapper) {
        super(repository, mapper);
    }

    @Cacheable(value = "university")
    @Override
    public DataDTO<UniversityDTO> create(UniversityCreateDTO createDto) {
        if (!checkYear(createDto.getOpenYear()))
            throw new BadRequestException("University open year must equal or less than " + createDto.getOpenYear(), University.class, "year");
        if (repository.existsByName(createDto.getName()))
            throw new AlreadyExistsException("The university with this name already exists", University.class, "universityId");
        University university = mapper.fromCreateDto(createDto);
        return new DataDTO<>(mapper.toDto(repository.save(university)));
    }

    @CacheEvict(value = "university")
    @Override
    public DataDTO<Void> delete(Long id) {
        University university = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("University not found", University.class, "universityID"));
        university.setDeleted(true);
        university.getFaculty().stream().forEach(faculty -> faculty.setDeleted(true));
        repository.save(university);
        return new DataDTO<>(true);
    }

    @CachePut(value = "university")
    @Override
    public DataDTO<UniversityDTO> update(UniversityUpdateDTO updateDto) {
        University university = repository.findByIdAndDeletedFalse(updateDto.getId()).orElseThrow(
                () -> new NotFoundException("University not found", University.class, "universityID"));
        if (updateDto.getName() != null)
            university.setName(updateDto.getName());
        if (updateDto.getAddress() != null)
            university.setAddress(updateDto.getAddress());
        if (updateDto.getOpenYear() > 0)
            university.setOpenYear(updateDto.getOpenYear());
        return new DataDTO<>(mapper.toDto(repository.save(university)));
    }
    @Cacheable(value = "university")
    @Override
    public DataDTO<UniversityDTO> get(Long id) {
        University university = repository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("University not found", University.class, "universityID"));
        return new DataDTO<>(mapper.toDto(university));
    }

    @Override
    public DataDTO<List<UniversityDTO>> getAll() {
        return new DataDTO<>(mapper.toDto(repository.findAllByDeletedFalse()));
    }

    public boolean checkYear(int year) {
        Date date = new Date();
        if (date.getYear() + 1900 < year)
            return false;
        return true;
    }
}
