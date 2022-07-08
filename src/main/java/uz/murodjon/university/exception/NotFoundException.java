package uz.murodjon.university.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final Class type;
    private final String search;

    public NotFoundException(String message, Class type, String search) {
        super(message);
        this.type = type;
        this.search = search;
    }
}
