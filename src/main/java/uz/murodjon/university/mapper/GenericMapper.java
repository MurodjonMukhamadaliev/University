package uz.murodjon.university.mapper;

import uz.murodjon.university.dto.BaseDTO;
import uz.murodjon.university.dto.GenericDTO;
import uz.murodjon.university.entity.BaseEntity;

import java.util.List;

public interface GenericMapper<
        E extends BaseEntity,
        D extends BaseDTO,
        CD extends BaseDTO,
        UD extends GenericDTO, L extends Number> extends BaseMapper {

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD d);
}
