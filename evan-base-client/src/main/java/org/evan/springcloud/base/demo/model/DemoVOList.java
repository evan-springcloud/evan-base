package org.evan.springcloud.base.demo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Evan.Shen
 * @since 2019-09-25
 */
public class DemoVOList extends ArrayList<DemoVO> {
    public DemoVOList() {
        super();
    }

    public DemoVOList(int size) {
        super(size);
    }

    public DemoVOList(List<DemoVO> list) {
        Collections.addAll(this, list.toArray(new DemoVO[]{}));
    }
}
