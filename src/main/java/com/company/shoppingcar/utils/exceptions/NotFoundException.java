package com.company.shoppingcar.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by juan.grisales on 4/8/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Custom message NotFoundException")
public class NotFoundException extends Exception{

}
