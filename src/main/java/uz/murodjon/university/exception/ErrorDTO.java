package uz.murodjon.university.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private String errorMessage;
    private int errorCode;
    private Map<String,String>validationErros;
//
//    public ErrorDTO() {
//    }
//
//    public ErrorDTO(String errorMessage, int errorCode) {
//        this.errorMessage = errorMessage;
//        this.errorCode = errorCode;
//    }
//
//    public ErrorDTO(String errorMessage, int errorCode, Map<String, String> validationErros) {
//        this.errorMessage = errorMessage;
//        this.errorCode = errorCode;
//        this.validationErros = validationErros;
//    }
//
//    public String getErrorMessage() {
//        return errorMessage;
//    }
//
//    public void setErrorMessage(String errorMessage) {
//        this.errorMessage = errorMessage;
//    }
//
//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(int errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public Map<String, String> getValidationErros() {
//        return validationErros;
//    }
//
//    public void setValidationErros(Map<String, String> validationErros) {
//        this.validationErros = validationErros;
//    }
}
