package org.evan.springcloud.base.demo.model;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@Component
public class DemoFactory {
    public Demo create(DemoAddUpdateParams demoAddUpdateParams) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoAddUpdateParams, demo);
        return demo;
    }

    public Demo create(DemoModel demoModel) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoModel, demo);
        return demo;
    }
}
