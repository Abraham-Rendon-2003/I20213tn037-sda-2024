package mx.edu.utez.sda.extra.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseA {
    private T data;
    private boolean error;
    private HttpStatus status;
    String message;
}
