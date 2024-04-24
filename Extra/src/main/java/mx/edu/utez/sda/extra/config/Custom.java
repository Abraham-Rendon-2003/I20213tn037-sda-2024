package mx.edu.utez.sda.extra.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class Custom {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseA<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> errorMessages = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errorMessages.add(fieldError.getDefaultMessage());
        }
        ResponseA<String> errorDetails = new ResponseA<>(
                null,
                true,
                HttpStatus.BAD_REQUEST,
                errorMessages.toString()

        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
