package uz.murodjon.university.service;

import uz.murodjon.university.dto.GenericDTO;
import uz.murodjon.university.dto.response.DataDTO;


import java.io.Serializable;
import java.util.List;



public interface GenericService<
        D extends GenericDTO,
        K extends Serializable> extends BaseService {

    DataDTO<List<D>> getAll();

    DataDTO<D> get(K id);

}
