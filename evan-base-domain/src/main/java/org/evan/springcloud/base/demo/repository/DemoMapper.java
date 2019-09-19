package org.evan.springcloud.base.demo.repository;

import org.apache.ibatis.annotations.Param;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoQuery;


import java.io.Serializable;
import java.util.List;

public interface DemoMapper {
    /***/
    Demo load(Long id);

    /***/
    void insert(Demo demo);

    /***/
    void update(Demo demo);

    /***/
    void updateStatus(@Param("id") Long id, @Param("status") Serializable status);

    /***/
    void delete(Long id);

    /***/
    List<Demo> queryList(DemoQuery demoQuery);

    /***/
    int queryCount(DemoQuery demoQuery);
}
