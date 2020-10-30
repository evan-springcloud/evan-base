package org.evan.springcloud.base.repository.mapper.first;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.evan.libraries.model.result.PageResult;
import org.evan.springcloud.base.model.demo.Demo;
import org.evan.springcloud.base.model.demo.DemoQueryDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface DemoMapper extends BaseMapper<Demo> {
    List<Demo> queryList(DemoQueryDTO demoQueryDTO);

    int queryCount(DemoQueryDTO demoQueryDTO);

    default PageResult<Demo> queryPage(DemoQueryDTO demoQueryDTO) {
        if (demoQueryDTO.getPageSize() == 0) {
            demoQueryDTO.setPageSize(DemoQueryDTO.DEFAULT_PAGE_SIZE);
        }

        int recordCount = queryCount(demoQueryDTO);

        PageResult<Demo> pageResult = new PageResult<>(demoQueryDTO);
        if (recordCount > 0) {
            List<Demo> demos = queryList(demoQueryDTO);
            pageResult.setData(demos);
        } else {
            pageResult.setData(new ArrayList<>());
        }
        pageResult.setRecordCount(recordCount);

        return pageResult;
    }

    default void  updateStatus(Long id, int status){
        Demo demo = new Demo(id);
        demo.setStatus(status);

        updateById(demo);
    }
}
