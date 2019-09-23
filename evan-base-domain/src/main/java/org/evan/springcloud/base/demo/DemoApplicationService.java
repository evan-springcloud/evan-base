package org.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.exception.DataNotFindException;
import org.evan.libraries.model.result.OperateCommonResultType;
import org.evan.libraries.model.result.OperateResult;
import org.evan.springcloud.base.demo.enums.PublishStatusEnum;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoAddUpdateDTO;
import org.evan.springcloud.base.demo.model.DemoFactory;
import org.evan.springcloud.base.demo.model.DemoPO;
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
    private DemoMapper demoMapper;
//    @Autowired
//    private RegionService regionService;
//    @Autowired
//    private Validator validator;
//    @Autowired
//    private DataDictionaryService dataDictionaryService;

    @Transactional
    public OperateResult<Demo> add(DemoAddUpdateDTO demoAddUpdateParams) {
        OperateResult result = OperateResult.create();
        // 验证
        //BeanValidators.validateWithException(validator, demoAddUpdateParams);
        Demo demo = demoFactory.create(demoAddUpdateParams);

        demoMapper.insert(demo);// 插入数据
        result.setData(demo);

        return result;
    }

    @Transactional
    public OperateResult update(DemoAddUpdateDTO demoAddUpdateParams) {
        OperateResult result = OperateResult.create();

        Long demoId = demoAddUpdateParams.getId();

        DemoPO demoOld = demoMapper.load(demoId);
        if (demoOld == null) {
            //通过返回代码告知调用者
            result.setCodeAndMsg(OperateCommonResultType.DATA_NOT_FIND.getCode(),"需要修改的Demo不存在或已删除,id[" + demoId + "]");
        } else {
            Demo demo = demoFactory.create(demoId, demoAddUpdateParams);
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
    public void remove(long demoId) {
        DemoPO demo = demoMapper.load(demoId);
        if (demo == null) {
            throw new DataNotFindException("需要删除的Demo不存在或已删除,id[" + demoId + "]"); //通过抛异常的方式告知调用者
        } else {
            demoMapper.delete(demoId);
        }
    }

    /**
     * 批量删除
     *
     * @param demoIds
     * @return
     */
    public void removeBatch(Long[] demoIds) {
        for (long demoId : demoIds) {
            demoMapper.delete(demoId);
        }
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
        DemoPO demo = demoMapper.load(demoId);
        if (demo == null) {
            result.setCodeAndMsg(OperateCommonResultType.DATA_NOT_FIND.getCode(),"需要变更状态的Demo不存在或已删除,id[" + demoId + "]");
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
    public void updateStatusBatch(Long[] demoIds, PublishStatusEnum newStatus) {
        OperateResult result = OperateResult.create();

        for (long demoId : demoIds) {
            updateStatusInner(demoId, newStatus);
        }
    }

    private void updateStatusInner(long demoId, PublishStatusEnum newStatus) {
        demoMapper.updateStatus(demoId, newStatus.getValue());
    }
}
