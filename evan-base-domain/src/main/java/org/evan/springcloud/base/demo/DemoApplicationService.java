package org.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.OperateCommonResultType;
import org.evan.libraries.model.result.OperateResult;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoAddUpdateParams;
import org.evan.springcloud.base.demo.model.DemoFactory;
import org.evan.springcloud.base.demo.model.DemoModel;
import org.evan.springcloud.base.demo.repository.DemoJdbc;
import org.evan.springcloud.base.demo.repository.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evan.Shen
 * @since 2019-08-09
 */
@Slf4j
@Service
public class DemoApplicationService {

    public static final String UPLOAD_FIRST_SUB_PATH = "/demo";

    @Autowired
    private DemoFactory demoFactory;

    @Autowired
    private DemoJdbc demoDao;

    @Autowired
    private DemoMapper demoMapper;
//    @Autowired
//    private RegionService regionService;
//    @Autowired
//    private Validator validator;
//    @Autowired
//    private DataDictionaryService dataDictionaryService;

    @Transactional
    public OperateResult add(DemoAddUpdateParams demoAddUpdateParams) {
        OperateResult result = OperateResult.create();
        // 验证
        //BeanValidators.validateWithException(validator, demoAddUpdateParams);
        Demo demo = demoFactory.create(demoAddUpdateParams);

        demoMapper.insert(demo);// 插入数据
        result.setData(demo);

        return result;
    }

    @Transactional
    public OperateResult update(long demoId, DemoAddUpdateParams demoAddUpdateParams) {
        OperateResult result = OperateResult.create();

        Demo demo = demoFactory.create(demoAddUpdateParams);

        DemoModel demoOld = demoMapper.load(demo.getId());
        if (demoOld == null) {
            result.setCode(OperateCommonResultType.DATA_NOT_FIND);
        } else {
            demoMapper.update(demo);
        }
        return result;
    }


    /**
     * 删除
     *
     * @param demoId
     * @return
     */
    @Transactional
    public OperateResult remove(long demoId) {
        OperateResult result = OperateResult.create();
        DemoModel demo = demoMapper.load(demoId);
        if (demo == null) {
            result.setCode(OperateCommonResultType.DATA_NOT_FIND);
        } else {
            demoMapper.delete(demoId);
        }
        return result;
    }

    /**
     * 批量删除
     *
     * @param demoIds
     * @return
     */
    public OperateResult removeBatch(Long[] demoIds) {
        OperateResult result = OperateResult.create();

        for (long demoId : demoIds) {
            demoMapper.delete(demoId);
        }
        return result;
    }

//    private void removeInner(long demo) {
//        demoMapper.delete(demo.getId());
//    }

    /**
     * 修改状态
     *
     * @param demoId
     * @param newStatus
     * @return
     */
    @Transactional
    public OperateResult updateStatus(long demoId, PublishStatusEnum newStatus) {
        OperateResult result = OperateResult.create();
        DemoModel demo = demoMapper.load(demoId);
        if (demo == null) {
            result.setCode(OperateCommonResultType.DATA_NOT_FIND);
        } else {
            updateStatusInner(demoId, newStatus);
        }
        return result;
    }

    /**
     * 批量修改状态
     *
     * @param demoIds
     * @param newStatus
     * @return
     */
    public OperateResult updateStatusBatch(Long[] demoIds, PublishStatusEnum newStatus) {
        OperateResult result = OperateResult.create();

        for (long demoId : demoIds) {
            updateStatusInner(demoId, newStatus);
        }
        return result;
    }

    private void updateStatusInner(long demoId, PublishStatusEnum newStatus) {
        demoMapper.updateStatus(demoId, newStatus.getValue());
    }
}
