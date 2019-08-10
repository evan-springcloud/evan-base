package org.evan.springcloud.base.repository.mapper;


import org.apache.ibatis.annotations.Param;
import org.evan.springcloud.base.query.DemoQuery;
import org.evan.springcloud.base.model.Demo;

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
