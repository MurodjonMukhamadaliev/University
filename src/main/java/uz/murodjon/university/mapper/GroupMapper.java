package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.group.GroupCreateDTO;
import uz.murodjon.university.dto.group.GroupDTO;
import uz.murodjon.university.dto.group.GroupUpdateDTO;
import uz.murodjon.university.entity.Group;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface GroupMapper extends GenericMapper<Group, GroupDTO, GroupCreateDTO, GroupUpdateDTO, Number> {
    @Override
    GroupDTO toDto(Group group);

    @Override
    List<GroupDTO> toDto(List<Group> e);

    @Override
    Group fromCreateDto(GroupCreateDTO groupCreateDTO);

    @Override
    Group fromUpdateDto(GroupUpdateDTO d);
}