package org.evan.springcloud.base.exceptions;

import org.evan.libraries.web.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 异常统一处理
 *
 * @author Evan.Shen
 * @since 2019-09-22
 */
@ControllerAdvice
public class BaseServiceGlobalExceptionHandler extends GlobalExceptionHandler {
}
