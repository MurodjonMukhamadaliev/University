package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.university.UniversityDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.service.university.UniversityServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("university/")
public class UniversityController extends AbstractController<UniversityServiceImpl> {
    public UniversityController(UniversityServiceImpl service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<DataDTO<UniversityDTO>> create(@RequestBody @Valid UniversityCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<UniversityDTO>> update(@RequestBody UniversityUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<UniversityDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<UniversityDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
