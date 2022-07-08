package uz.murodjon.university.service;


import uz.murodjon.university.mapper.BaseMapper;
import uz.murodjon.university.repository.BaseRepository;

public abstract class AbstractService<R extends BaseRepository, M extends BaseMapper> implements BaseService {
    protected R repository;
    protected M mapper;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
