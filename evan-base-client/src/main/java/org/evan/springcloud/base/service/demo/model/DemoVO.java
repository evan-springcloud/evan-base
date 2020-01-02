package org.evan.springcloud.base.service.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@ApiModel("Demo输出对象")
@Data
public class DemoVO extends Demo {
    @Override
    public String toString() {
        return "DemoVO{} " + super.toString();
    }
}
