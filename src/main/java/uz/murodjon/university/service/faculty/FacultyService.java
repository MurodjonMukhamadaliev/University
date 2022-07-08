package uz.murodjon.university.service.faculty;

import org.springframework.http.ResponseEntity;
import uz.murodjon.university.dto.faculty.FacultyCreateDTO;
import uz.murodjon.university.dto.faculty.FacultyDTO;
import uz.murodjon.university.dto.faculty.FacultyUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.Faculty;
import uz.murodjon.university.service.GenericCrudService;

import java.util.List;

public interface FacultyService extends GenericCrudService<Faculty, FacultyDTO, FacultyCreateDTO, FacultyUpdateDTO, Long> {
    @Override
    DataDTO<FacultyDTO> create(FacultyCreateDTO createDto);

    @Override
    DataDTO<Void> delete(Long id);

    @Override
    DataDTO<FacultyDTO> update(FacultyUpdateDTO updateDto);

    @Override
    DataDTO<List<FacultyDTO>> getAll();

    @Override
    DataDTO<FacultyDTO> get(Long id);

    DataDTO<List<FacultyDTO>> getAllByUniversityId(Long id);
}