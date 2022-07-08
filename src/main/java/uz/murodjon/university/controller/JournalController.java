package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.dto.journal.JournalCreateDTO;
import uz.murodjon.university.dto.journal.JournalDTO;
import uz.murodjon.university.dto.journal.JournalUpdateDTO;
import uz.murodjon.university.service.journal.JournalServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("journal/")
public class JournalController extends AbstractController<JournalServiceImpl> {
    public JournalController(JournalServiceImpl service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<DataDTO<JournalDTO>> create(@RequestBody @Valid JournalCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<JournalDTO>> update(@RequestBody JournalUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<JournalDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<JournalDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
