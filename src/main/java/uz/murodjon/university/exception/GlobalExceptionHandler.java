package uz.murodjon.university.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ErrorDTO notFoundExceptionHandler(NotFoundException e) {
        return ErrorDTO
                .builder()
                .errorCode(404)
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler({AlreadyExistsException.class})
    public ErrorDTO alreadyExistsExceptionHandler(AlreadyExistsException e) {
        return ErrorDTO
                .builder()
                .errorCode(409)
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler({BadRequestException.class})
    public ErrorDTO badRequestException(BadRequestException e) {
        return ErrorDTO
                .builder()
                .errorCode(400)
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ErrorDTO validationExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ErrorDTO
                .builder()
                .errorCode(4003)
                .errorMessage("Validation error!")
                .validationErros(validationErrors)
                .build();
    }
}