package org.springproj.web.rest;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ProjAdvice {

    private final TeamValidator teamValidator;


    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(teamValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.info("IllegalArgument exception " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(ex.getMessage());
    }

}
