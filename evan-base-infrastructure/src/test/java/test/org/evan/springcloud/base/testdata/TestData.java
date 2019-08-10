package test.org.evan.springcloud.base.testdata;

import org.evan.springcloud.base.model.Demo;
import org.evan.springcloud.base.utils.RandomUtil;

import java.math.BigDecimal;

public class TestData {
    public static Demo random() {

        Demo demo = new Demo();

        demo.setFieldText(randomTitle());
        demo.setFieldNumber(new BigDecimal(RandomUtil.randomInt(999999)));
        demo.setFieldRadio("1");
        // demo.setFieldCheckboxArray(new EnumSex[] { EnumSex.WOMAN });
        demo.setFieldSelect("2");
        demo.setFieldHtmleditorCut(RandomUtil.randomName("TestCut"));
        demo.setFieldHtmleditor(RandomUtil.randomName("TestContent"));
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
        return RandomUtil.randomName("DEMO");
    }

}
