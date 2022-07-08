package uz.murodjon.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.murodjon.university.dto.group.GroupCreateDTO;
import uz.murodjon.university.dto.group.GroupDTO;
import uz.murodjon.university.dto.group.GroupUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.service.group.GroupServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("group/")
public class GroupController extends AbstractController<GroupServiceImpl> {
    public GroupController(GroupServiceImpl service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<DataDTO<GroupDTO>> create(@RequestBody @Valid GroupCreateDTO createDTO) {
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping
    public ResponseEntity<DataDTO<GroupDTO>> update(@RequestBody GroupUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(updateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDTO<GroupDTO>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<DataDTO<List<GroupDTO>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("faculty/{id}")
    public ResponseEntity<DataDTO<List<GroupDTO>>> getAllByFaculty(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAllByFacultyId(id));
    }

    @GetMapping("/mark/{id}")
    public ResponseEntity<?> getMarksStudentGroups(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.getMarkStudent(id));
    }

}
