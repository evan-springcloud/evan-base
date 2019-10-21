package org.evan.springcloud.base.demo;

import org.evan.libraries.utils.BeanUtil;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.evan.springcloud.base.demo.model.DemoVO;
import org.springframework.stereotype.Component;

/**
 * Demo 领域模型创建工厂
 *
 * @author Evan.Shen
 * @since 2019-09-20
 */
@Component
public class DemoFactory {

    public Demo createDemo(DemoAddUpdateDTO demoAddUpdateParams) {
        Demo demo = new Demo();
        BeanUtil.quickCopy(demoAddUpdateParams, demo);
        return demo;
    }

    public DemoVO createDemoVO(Demo demo) {
        DemoVO demoVO = new DemoVO();
        BeanUtil.quickCopy(demo, demoVO);
        return demoVO;
    }

    public DemoDomain createDemoDomain(DemoAddUpdateDTO demoAddUpdateParams) {
        DemoDomain demo = new DemoDomain();
        BeanUtil.quickCopy(demoAddUpdateParams, demo);
        return demo;
    }

    public DemoDomain createDemoDomain(long demoId, DemoAddUpdateDTO demoAddUpdateParams) {
        DemoDomain demo = createDemoDomain(demoAddUpdateParams);
        demo.setId(demoId);
        return demo;
    }

    public DemoDomain createDemoDomain(Demo demo) {
        DemoDomain DemoDomain = new DemoDomain();
        BeanUtil.quickCopy(demo, DemoDomain);
        return DemoDomain;
    }
}
