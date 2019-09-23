package test.evan.springcloud.base.demo;

import org.evan.libraries.utils.RandomDataUtil;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.evan.springcloud.base.demo.model.DemoPO;

import java.math.BigDecimal;

public class DemoTestData {
    public static DemoPO randomDemoPO() {

        DemoPO demo = new DemoPO();

        demo.setFieldText(randomTitle());
        demo.setFieldNumber(new BigDecimal(RandomDataUtil.randomInt(999999)));
        demo.setFieldRadio("1");
        // demo.setFieldCheckboxArray(new EnumSex[] { EnumSex.WOMAN });
        demo.setFieldSelect("2");
        demo.setFieldHtmleditorCut(RandomDataUtil.randomName("TestCut"));
        demo.setFieldHtmleditor(RandomDataUtil.randomName("TestContent"));
        demo.setFieldProvince("330000");

        demo.setFieldCity("330100");
        demo.setFieldRegion("330106");

//		ImageUploador iu = new ImageUploador();
//		iu.setNo(2);
//		iu.setScaleFileUploadedPath("/a/b");
//
//		demo.setPicture(iu);

        return demo;
    }

    public static DemoAddUpdateDTO randomDemoAddUpdateParams() {

        DemoAddUpdateDTO demo = new DemoAddUpdateDTO();

        demo.setFieldText(randomTitle());
        demo.setFieldNumber(new BigDecimal(RandomDataUtil.randomInt(999999)));
        demo.setFieldRadio("1");
        demo.setFieldSelect("2");
        demo.setFieldHtmleditorCut(RandomDataUtil.randomName("TestCut"));
        demo.setFieldHtmleditor(RandomDataUtil.randomName("TestContent"));
        demo.setFieldProvince("330000");
        demo.setFieldCity("330100");
        demo.setFieldRegion("330106");

        return demo;
    }

    // public static DemoEntity randomEntity() {
    // DemoEntity demo = new DemoEntity();
    // demo.setFieldText(randomTitle());
    // demo.setFieldNumber(new BigDecimal(RandomData.randomInt()));
    // demo.setFieldRadio("2");
    // demo.setFieldCheckbox("2");
    // demo.setFieldSelect("2");
    // demo.setFieldHtmleditorCut(RandomData.randomName("TestCut"));
    // demo.setFieldHtmleditor(RandomData.randomName("TestContent"));
    // demo.setFieldProvince("330000");
    // demo.setFieldCity("330100");
    // demo.setFieldRegion("330106");
    // demo.setFieldDate(new Date());
    // demo.setFieldDatetime(new Date());
    //
    // return demo;
    // }

    public static String randomTitle() {
        return RandomDataUtil.randomName("DEMO");
    }

}
