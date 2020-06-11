package org.evan.springcloud.base.repository.mapper.first;


import org.apache.ibatis.annotations.Param;
import org.evan.libraries.model.result.PageResult;
import org.evan.springcloud.base.model.demo.Demo;
import org.evan.springcloud.base.model.demo.DemoQueryDTO;

import java.io.Serializable;
import java.util.List;

public interface DemoMapper {
    /***/
    Demo selectById(Long id);

    /***/
    void insert(Demo demo);

    /***/
    void update(Demo demo);

    /***/
    void updateStatus(@Param("id") Long id, @Param("status") Serializable status);

    /***/
    void delete(Long id);

    /***/
    List<Demo> queryList(DemoQueryDTO demoQueryDTO);

    /***/
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
        }
        pageResult.setRecordCount(recordCount);

        return pageResult;
    }
}
