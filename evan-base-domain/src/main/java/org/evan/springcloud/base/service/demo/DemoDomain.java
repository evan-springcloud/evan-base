package org.evan.springcloud.base.service.demo;

import org.evan.libraries.utils.BeanUtil;
import org.evan.springcloud.base.enums.PublishStatusEnum;
import org.evan.springcloud.base.model.demo.Demo;
import org.evan.springcloud.base.model.demo.DemoAddUpdateDTO;

/**
 * Demo领域模型
 *
 * @author Evan.Shen
 * @since 2019-09-20
 */
public class DemoDomain extends Demo {
    public DemoDomain newDemo(DemoAddUpdateDTO demoAddUpdateParams) {
        DemoDomain demoDomain = new DemoDomain();
        BeanUtil.quickCopy(demoAddUpdateParams, demoDomain);
        demoDomain.setStatus(PublishStatusEnum.PUBLISHED.getValue());
        return demoDomain;
    }

    public DemoDomain updateDemo(long id, DemoAddUpdateDTO demoAddUpdateParams) {
        DemoDomain demoDomain = new DemoDomain();

        BeanUtil.quickCopy(demoAddUpdateParams, demoDomain);
        demoDomain.setId(id);

        return demoDomain;
    }
}
