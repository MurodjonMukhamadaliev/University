package uz.murodjon.university.service.group;

import org.springframework.http.ResponseEntity;
import uz.murodjon.university.dto.group.GroupCreateDTO;
import uz.murodjon.university.dto.group.GroupDTO;
import uz.murodjon.university.dto.group.GroupUpdateDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.Group;
import uz.murodjon.university.service.GenericCrudService;

import java.util.List;

public interface GroupService extends GenericCrudService<Group, GroupDTO, GroupCreateDTO, GroupUpdateDTO, Long> {

    @Override
    DataDTO<GroupDTO> create(GroupCreateDTO createDto);


    @Override
    DataDTO<Void> delete(Long id);

    @Override
    DataDTO<GroupDTO> update(GroupUpdateDTO updateDto);

    @Override
    DataDTO<List<GroupDTO>> getAll();


    DataDTO<List<GroupDTO>> getAllByFacultyId(Long id);

    @Override
    DataDTO<GroupDTO> get(Long id);

    DataDTO<?>getMarkStudent(Long id);

}