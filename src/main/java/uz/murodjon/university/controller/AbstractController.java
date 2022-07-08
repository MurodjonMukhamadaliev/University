package uz.murodjon.university.controller;

import lombok.RequiredArgsConstructor;
import uz.murodjon.university.service.AbstractService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends AbstractService> {
    protected final S service;
    protected final String API = "/api";
    protected final String VERSION = "/v1";
    protected final String PATH = API + VERSION;
}
