package uz.murodjon.university.service.mark;

import uz.murodjon.university.dto.mark.MarkCreateDTO;
import uz.murodjon.university.dto.mark.MarkDTO;
import uz.murodjon.university.dto.mark.MarkUpdateDTO;
import uz.murodjon.university.entity.Mark;
import uz.murodjon.university.service.GenericCrudService;

public interface MarkService extends GenericCrudService<Mark, MarkDTO, MarkCreateDTO, MarkUpdateDTO, Long> {
}
