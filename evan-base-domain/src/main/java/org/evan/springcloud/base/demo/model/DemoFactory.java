package org.evan.springcloud.base.demo.model;

import org.evan.springcloud.base.utils.BeanUtil;
import org.springframework.stereotype.Component;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@Component
public class DemoFactory {
    public Demo create(DemoAddUpdateParams demoAddUpdateParams) {
        Demo demo = new Demo();
        BeanUtil.quickCopy(demoAddUpdateParams, demo);
        return demo;
    }

    public Demo create(long demoId, DemoAddUpdateParams demoAddUpdateParams) {
        Demo demo = create(demoAddUpdateParams);
        demo.setId(demoId);
        return demo;
    }

    public Demo create(DemoModel demoModel) {
        Demo demo = new Demo();
        BeanUtil.quickCopy(demoModel, demo);
        return demo;
    }
}
