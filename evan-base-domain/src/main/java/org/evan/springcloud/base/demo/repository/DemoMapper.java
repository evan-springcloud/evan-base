package org.evan.springcloud.base.demo.repository;

import org.apache.ibatis.annotations.Param;
import org.evan.springcloud.base.demo.model.DemoPO;
import org.evan.springcloud.base.demo.model.DemoQueryDTO;


import java.io.Serializable;
import java.util.List;

public interface DemoMapper {
    /***/
    DemoPO load(Long id);

    /***/
    void insert(DemoPO demo);

    /***/
    void update(DemoPO demo);

    /***/
    void updateStatus(@Param("id") Long id, @Param("status") Serializable status);

    /***/
    void delete(Long id);

    /***/
    List<DemoPO> queryList(DemoQueryDTO demoQuery);

    /***/
    int queryCount(DemoQueryDTO demoQuery);
}
