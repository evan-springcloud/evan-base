package org.evan.springcloud.base.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@ApiModel("示例")
@Data
public class DemoRepresentation extends DemoModel {
    @Override
    public String toString() {
        return "DemoRepresentation{} " + super.toString();
    }
}
