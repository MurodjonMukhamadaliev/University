package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.student.StudentCreateDTO;
import uz.murodjon.university.dto.student.StudentUpdateDTO;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.student.StudentDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.service.student.StudentServiceImpl;
import uz.murodjon.university.service.university.UniversityServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentController extends AbstractController<StudentServiceImpl>{
    public StudentController(StudentServiceImpl service) {
        super(service);
    }
    @PostMapping
    public ResponseEntity<DataDTO<StudentDTO>> create(@RequestBody @Valid StudentCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<StudentDTO>> update(@RequestBody StudentUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<StudentDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<StudentDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
