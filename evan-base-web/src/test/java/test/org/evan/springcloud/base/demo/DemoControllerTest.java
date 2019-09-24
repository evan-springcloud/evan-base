package test.org.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.RestResponse;
import org.evan.libraries.utils.DateUtil;
import org.evan.libraries.utils.RandomDataUtil;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.evan.springcloud.base.demo.model.DemoVO;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import test.org.evan.springcloud.base.support.WebTestCaseSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DemoControllerTest extends WebTestCaseSupport {

    private ParameterizedTypeReference<RestResponse<DemoVO>> responseTypeForOne = new ParameterizedTypeReference<RestResponse<DemoVO>>() {
    };

    private ParameterizedTypeReference<RestResponse<List<DemoVO>>> responseTypeForList = new ParameterizedTypeReference<RestResponse<List<DemoVO>>>() {
    };

    @Test
    public void testGetList() {
        String url = getFullApiUri("/demo/list?pageSize={pageSize}&sort={sort}&stringValue=中文");

        Map<String, Object> parames = new HashMap<>();
        parames.put("pageSize", 15);
        parames.put("sort", "gmt_modify");
        //parames.put("dateValue", "2016-12-01");

        ResponseEntity<String> responseEntity1 = restTemplate.getForEntity(url, String.class, parames);
        log.info("========>>testGetList 结果1：" + responseEntity1.getBody());

        ResponseEntity<RestResponse<List<DemoVO>>> responseEntity2 = restTemplate.exchange(url, HttpMethod.GET, null, responseTypeForList, parames);
        log.info("========>>testGetList 结果2：" + responseEntity2.getBody());
    }

    @Test
    public void testLoad() {
        String url = getFullApiUri("/demo/load?id={0}");

        String response1 = restTemplate.getForObject(url, String.class, 107);
        log.info("========>>testLoad 结果：" + response1);

        ResponseEntity<RestResponse<DemoVO>> responseEntity2 = restTemplate.exchange(url, HttpMethod.GET, null, responseTypeForOne, 107);
        log.info("========>>testLoad 结果：" + responseEntity2.getBody());
    }

    @Test
    public void testAdd() {
        String url = getFullApiUri("/demo/add");
        DemoAddUpdateDTO demo = DemoTestData.randomDemoAddUpdateParams();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, Object> demoMap = BeanUtil.beanToMap2(demo);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : demoMap.entrySet()) {
            Object val = entry.getValue();
            if (val != null) {
                String strVal = null;

                if (val instanceof Date) {
                    strVal = DateUtil.format((Date) val, DateUtil.FORMAT_FULL_STRING);
                } else {
                    strVal = val.toString();
                }
                formData.add(entry.getKey(), strVal);
            }
        }

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, httpHeaders);

        ResponseEntity<RestResponse<DemoVO>> responseEntity1 = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseTypeForOne);
        log.info("========>>testAdd 结果：" + responseEntity1.getBody());
    }

    @Test
    public void testUpdate() {
        String url = getFullApiUri("/demo/update");
        DemoAddUpdateDTO demo = DemoTestData.randomDemoAddUpdateParams();
        long demoId = RandomDataUtil.randomInt(50);
        demo.setId(demoId);
        RestResponse response = restTemplate.postForObject(url, demo, RestResponse.class);
        log.info("========>>testUpdate 结果：" + response);
    }

    @Test
    public void testDelete() {
        String url = getFullApiUri("/demo/delete?id={0}");
        long demoId = RandomDataUtil.randomInt(50);
        RestResponse response = restTemplate.postForObject(url, null, RestResponse.class, demoId);
        log.info("========>>testDelete 结果：" + response);
    }

    @Test
    public void testDeleteBatch() {
        String url = getFullApiUri("/demo/delete-batch?ids={0}");
        RestResponse response = restTemplate.postForObject(url, null, RestResponse.class, "1,3");
        log.info("========>>testDeleteBatch 结果：" + response);
    }

    @Test
    public void testUpdateStatus2() {
        String url = getFullApiUri("/demo/update-status?id={id}&newStatus={newStatus}");

        Map<String, Object> parames = new HashMap<>();

        long demoId = RandomDataUtil.randomInt(50);
        PublishStatusEnum newStatus = demoId % 2 == 0 ? PublishStatusEnum.PUBLISHED : PublishStatusEnum.NO_PUBLISH;

        parames.put("id", demoId);
        parames.put("newStatus", newStatus.getValue());

        RestResponse response = restTemplate.postForObject(url, null, RestResponse.class, parames);
        log.info("========>>testUpdateStatus 结果：" + response);
    }

    @Test
    public void testUpdateStatusBatch() {
        String url = getFullApiUri("/demo/update-status-batch?ids={ids}&newStatus={newStatus}");

        Map<String, Object> parames = new HashMap<>();
        parames.put("ids", "124,1424");
        parames.put("newStatus", "2");

        RestResponse response = restTemplate.postForObject(url, null, RestResponse.class, parames);
        log.info("========>>testUpdateStatusBatch 结果：" + response);
    }

//    @Test
//    public void testHttpMethodError() {
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getFullApiUri("/demo/operate-seccess"), String.class);
//        log.info("========>>结果：" + responseEntity.getBody());
//    }
//
//
//    @Test
//    public void testSystemException() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/system-exception"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void testServiceException() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/strategy-exception"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void testParameMustWrong() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/parame-wrong?string2=string2"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void testParameMustWrong2() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/parame-wrong?string1=string1"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void testParameTypeWrong() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/parame-wrong?code=a"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void testCache() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/cache"), String.class);
//        log.info("========>>结果：" + result);
//    }
//
//    @Test
//    public void test404() {
//        String result = restTemplate.getForObject(getFullApiUri("/demo/test-404"), String.class);
//        log.info("========>>结果：" + result);
//    }

//    @Test
//    public void testPostList() {
//        Map<String, Object> parames = new HashMap<String, Object>();
//        parames.put("pageSize", 15);
//        parames.put("sort", "gmt_create");
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(getFullApiUri("/demo/list"), parames, String.class);
//        log.info("========>>结果：" + responseEntity.getBody());
//    }
}
