package com.sngular.omb.ombapi.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * Class Exception Format class.
 * */
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionFormat extends  RuntimeException {

   // private  final Long timeStamp;
    /**Status Value.*/
    private final int status;

    /**Error Code.*/
    private final String errorCode;

    /**Accounts Repository.*/
    private final HttpStatus httpStatus;

    /**
     * Exception Format Constructor.
     * */
    public  ExceptionFormat(final int status,final String message, final HttpStatus httpStatus){
        super(message);
        this.status = status;
        this.errorCode = null;
        this.httpStatus = httpStatus;
    }

}
