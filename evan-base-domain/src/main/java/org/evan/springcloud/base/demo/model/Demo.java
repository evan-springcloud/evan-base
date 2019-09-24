package org.evan.springcloud.base.demo.model;

import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.utils.BeanUtil;

/**
 * Demo领域模型
 *
 * @author Evan.Shen
 * @since 2019-09-20
 */
public class Demo extends DemoPO {
    public Demo newDemo(DemoAddUpdateDTO demoAddUpdateParams) {
        Demo demo = new Demo();
        BeanUtil.quickCopy(demoAddUpdateParams, demo);
        demo.setStatus(PublishStatusEnum.PUBLISHED.getValue());
        return demo;
    }

    public Demo updateDemo(long id, DemoAddUpdateDTO demoAddUpdateParams) {
        Demo demo = new Demo();

        BeanUtil.quickCopy(demoAddUpdateParams, demo);
        demo.setId(id);

        return demo;
    }
}
