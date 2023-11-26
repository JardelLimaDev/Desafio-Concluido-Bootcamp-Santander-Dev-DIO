package dio.desafio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptions {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptions.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> businessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> notFounException(NoSuchElementException notFoundException){
        return new ResponseEntity<>("ID não encontrado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> unexpectedException(Throwable unexpectedException){
        var message = "Erro inesperado do servidor, consulte os logs.";
        logger.error("", unexpectedException);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
