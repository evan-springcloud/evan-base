package org.evan.springcloud.base.demo.repository;

import org.apache.ibatis.annotations.Param;
import org.evan.springcloud.base.demo.model.DemoModel;
import org.evan.springcloud.base.demo.model.DemoQuery;


import java.io.Serializable;
import java.util.List;

public interface DemoMapper {
    /***/
    DemoModel load(Long id);

    /***/
    void insert(DemoModel demo);

    /***/
    void update(DemoModel demo);

    /***/
    void updateStatus(@Param("id") Long id, @Param("status") Serializable status);

    /***/
    void delete(Long id);

    /***/
    List<DemoModel> queryList(DemoQuery demoQuery);

    /***/
    int queryCount(DemoQuery demoQuery);
}
