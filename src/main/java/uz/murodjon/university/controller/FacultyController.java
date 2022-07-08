package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.faculty.FacultyCreateDTO;
import uz.murodjon.university.dto.faculty.FacultyDTO;
import uz.murodjon.university.dto.faculty.FacultyUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.service.faculty.FacultyServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("faculty/")
public class FacultyController extends AbstractController<FacultyServiceImpl> {
    public FacultyController(FacultyServiceImpl service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<DataDTO<FacultyDTO>> create(@RequestBody @Valid FacultyCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<FacultyDTO>> update(@RequestBody FacultyUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<FacultyDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<FacultyDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getAllByUniversity/{id}")
    public ResponseEntity<DataDTO<List<FacultyDTO>>> getAllByUniversityId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAllByUniversityId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
