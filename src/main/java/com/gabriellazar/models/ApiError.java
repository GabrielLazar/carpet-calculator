package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String message;

    public ApiError(int statusCode,HttpStatus status, Throwable message){
        timeStamp = LocalDateTime.now();
        this.statusCode = statusCode;
        this.status = status;
        this.message = message.getLocalizedMessage();
    }

}
