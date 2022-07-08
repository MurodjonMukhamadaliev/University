package uz.murodjon.university.service.university;

import org.springframework.http.ResponseEntity;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.university.UniversityDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.entity.University;
import uz.murodjon.university.service.GenericCrudService;

import java.util.List;

public interface UniversityService extends GenericCrudService<University, UniversityDTO, UniversityCreateDTO, UniversityUpdateDTO, Long> {

    @Override
    DataDTO<UniversityDTO> create(UniversityCreateDTO createDto);

    @Override
    DataDTO<Void> delete(Long id);

    @Override
    DataDTO<UniversityDTO> update(UniversityUpdateDTO updateDto);

    @Override
    DataDTO<List<UniversityDTO>> getAll();

    @Override
    DataDTO<UniversityDTO> get(Long id);
}
