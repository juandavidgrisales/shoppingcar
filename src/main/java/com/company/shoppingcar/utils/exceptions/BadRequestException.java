package com.company.shoppingcar.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by juan.grisales on 4/8/2016.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Solicitud realizada con datos incorrectos")
public class BadRequestException extends Exception {

}
