package org.evan.springcloud.base.exceptions;

import org.evan.libraries.rest.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author Evan.Shen
 * @since 2019-09-22
 */
@ControllerAdvice
public class BaseServiceGlobalExceptionHandler extends GlobalExceptionHandler {
}
