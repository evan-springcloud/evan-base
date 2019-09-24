package test.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.exception.DataNotFindException;
import org.evan.libraries.model.result.OperateResult;
import org.evan.libraries.utils.RandomDataUtil;
import org.evan.springcloud.base.demo.DemoApplicationService;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.evan.springcloud.base.support.ApplicationTestCaseSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * DemoApplicationService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 21, 2019</pre>
 */
@Slf4j
public class DemoApplicationServiceTest extends ApplicationTestCaseSupport {

    @Autowired
    private DemoApplicationService demoService;

    @Test
    //@Rollback(false)
    public void testAdd() {
        DemoAddUpdateDTO demoAddUpdateParams = DemoTestData.randomDemoAddUpdateParams();
        OperateResult<Demo> result = demoService.add(demoAddUpdateParams);

        log.info(">>>> testAdd: " + result);
    }

    @Test
    //@Rollback(false)
    public void testUpdate() throws DataNotFindException {
        DemoAddUpdateDTO demoAddUpdateParams = DemoTestData.randomDemoAddUpdateParams();
        long demoId = RandomDataUtil.randomInt(50);
        OperateResult result = demoService.update(demoAddUpdateParams);

        log.info(">>>> testUpdate: " + result);
    }

    /**
     * Method: remove(long demoId)
     */
    @Test
    public void testRemove() {
        long demoId = RandomDataUtil.randomInt(50);
        demoService.remove(demoId);
        //log.info(">>>> testRemove: "+ result);
    }

    /**
     * Method: removeBatch(long[] demoIds)
     */
    @Test
    public void testRemoveBatch() {
        List<Long> demoIds = new ArrayList<>();
        int count = RandomDataUtil.randomInt(3);

        for (int i = 0; i < count; i++) {
            demoIds.add(RandomDataUtil.randomLong(10 * (i + 1)));
        }

        demoService.removeBatch(demoIds.toArray(new Long[]{}));
        //log.info(">>>> testRemoveBatch: "+ result);
    }

    /**
     * Method: updateStatus(long demoId, PublishStatusEnum newStatus)
     */
    @Test
    public void testUpdateStatus() {
        long demoId = RandomDataUtil.randomInt(50);
        PublishStatusEnum newStatus = demoId % 2 == 0 ? PublishStatusEnum.PUBLISHED : PublishStatusEnum.NO_PUBLISH;
        OperateResult result = demoService.updateStatus(demoId, newStatus);
        log.info(">>>> testUpdateStatus: " + result);
    }

    /**
     * Method: updateStatusBatch(long[] demoIds, PublishStatusEnum newStatus)
     */
    @Test
    public void testUpdateStatusBatch() {
        List<Long> demoIds = new ArrayList<>();
        int count = RandomDataUtil.randomInt(20);

        for (int i = 0; i < count; i++) {
            demoIds.add(RandomDataUtil.randomLong(10 * (i + 1)));
        }
        PublishStatusEnum newStatus = count % 2 == 0 ? PublishStatusEnum.PUBLISHED : PublishStatusEnum.NO_PUBLISH;

        demoService.updateStatusBatch(demoIds.toArray(new Long[]{}), newStatus);
        //log.info(">>>> testUpdateStatusBatch: "+ result);
    }

} 
