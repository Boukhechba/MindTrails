package org.mindtrails.domain.RestExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dan on 10/26/15.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "You can not assign this person as a coach unless they are marked as a coach.")
public class NotACoachException extends RuntimeException {}
