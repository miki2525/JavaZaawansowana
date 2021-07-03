package project.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.exception.jaznbpBadRequest;
import project.exception.jaznbpNotFoundException;


@RestControllerAdvice
public class JaznbpGlobalExceptionHandler {


    @ExceptionHandler(jaznbpBadRequest.class)
    public ResponseEntity<String> handleRuntimeException(jaznbpBadRequest e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Exception message: " + e.getLocalizedMessage());
    }

    @ExceptionHandler(jaznbpNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(jaznbpNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not found");
    }

}
