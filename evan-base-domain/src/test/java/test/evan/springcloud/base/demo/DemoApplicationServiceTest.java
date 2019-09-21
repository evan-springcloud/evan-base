package test.evan.springcloud.base.demo;

import org.evan.libraries.exception.DataNotFindException;
import org.evan.libraries.utils.RandomDataUtil;
import org.evan.springcloud.base.demo.DemoApplicationService;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.DemoAddUpdateParams;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
public class DemoApplicationServiceTest extends ApplicationTestCaseSupport {

    @Autowired
    private DemoApplicationService demoService;

    @Test
    @Rollback(false)
    public void testAdd() {
        DemoAddUpdateParams demoAddUpdateParams = DemoTestData.randomDemoAddUpdateParams();
        demoService.add(demoAddUpdateParams);
    }

    @Test
    @Rollback(false)
    public void testUpdate() throws DataNotFindException {
        DemoAddUpdateParams demoAddUpdateParams = DemoTestData.randomDemoAddUpdateParams();

        long demoId = RandomDataUtil.randomInt(50);

        demoService.update(demoId, demoAddUpdateParams);
    }

    /**
     * Method: remove(long demoId)
     */
    @Test
    public void testRemove() {
        long demoId = RandomDataUtil.randomInt(50);
        demoService.remove(demoId);
    }

    /**
     * Method: removeBatch(long[] demoIds)
     */
    @Test
    public void testRemoveBatch() {
        List<Long> demoIds = new ArrayList<>();
        int count = RandomDataUtil.randomInt(10);

        for (int i = 0; i < count; i++) {
            demoIds.add(RandomDataUtil.randomLong(10 * (i + 1)));
        }

        demoService.removeBatch(demoIds.toArray(new Long[]{}));
    }

    /**
     * Method: updateStatus(long demoId, PublishStatusEnum newStatus)
     */
    @Test
    public void testUpdateStatus() {
        long demoId = RandomDataUtil.randomInt(50);
        PublishStatusEnum newStatus = demoId % 2 == 0 ? PublishStatusEnum.PUBLISHED : PublishStatusEnum.NO_PUBLISH;
        demoService.updateStatus(demoId, newStatus);
    }

    /**
     * Method: updateStatusBatch(long[] demoIds, PublishStatusEnum newStatus)
     */
    @Test
    public void testUpdateStatusBatch() {
        List<Long> demoIds = new ArrayList<>();
        int count = RandomDataUtil.randomInt(10);

        for (int i = 0; i < count; i++) {
            demoIds.add(RandomDataUtil.randomLong(10 * (i + 1)));
        }
        PublishStatusEnum newStatus = count % 2 == 0 ? PublishStatusEnum.PUBLISHED : PublishStatusEnum.NO_PUBLISH;

        demoService.updateStatusBatch(demoIds.toArray(new Long[]{}), newStatus);
    }

} 
