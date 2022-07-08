package uz.murodjon.university.service;

import org.springframework.http.ResponseEntity;
import uz.murodjon.university.dto.BaseDTO;
import uz.murodjon.university.dto.GenericDTO;
import uz.murodjon.university.dto.response.DataDTO;
import uz.murodjon.university.entity.BaseEntity;

import java.io.Serializable;

public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDTO,
        CD extends BaseDTO,
        UD extends GenericDTO,
        K extends Serializable> extends GenericService<D, K> {

    DataDTO<D> create(CD createDto);

    DataDTO<Void> delete(K id);

    DataDTO<D> update(UD updateDto);

}
