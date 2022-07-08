package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.mark.MarkCreateDTO;
import uz.murodjon.university.dto.mark.MarkUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.university.UniversityCreateDTO;
import uz.murodjon.university.dto.mark.MarkDTO;
import uz.murodjon.university.dto.university.UniversityUpdateDTO;
import uz.murodjon.university.service.mark.MarkServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("mark/")
public class MarkController extends AbstractController<MarkServiceImpl>{
    public MarkController(MarkServiceImpl service) {
        super(service);
    }
    @PostMapping
    public ResponseEntity<DataDTO<MarkDTO>> create(@RequestBody @Valid MarkCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<MarkDTO>> update(@RequestBody MarkUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<MarkDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<MarkDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }


}
