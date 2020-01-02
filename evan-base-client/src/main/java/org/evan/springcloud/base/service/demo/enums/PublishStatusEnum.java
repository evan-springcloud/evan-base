package org.evan.springcloud.base.service.demo.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * 发布状态
 */
public enum PublishStatusEnum  {
    /**
     * 未发布
     */
    NO_PUBLISH(1, "未发布"),
    /**
     * 已发布
     */
    PUBLISHED(2, "已发布");

    private static final Map<Integer, PublishStatusEnum> POOL = new HashMap<Integer, PublishStatusEnum>();

    static {
        for (PublishStatusEnum each : PublishStatusEnum.values()) {
            PublishStatusEnum defined = POOL.get(each.getValue());
            if (null != defined) {
                throw new IllegalArgumentException(defined.toString()
                        + " defined as same code with " + each.toString());
            }
            POOL.put(each.getValue(), each);
        }
    }

    private Integer value;
    private String text;

    PublishStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static PublishStatusEnum valueOf(int value) {
        return POOL.get(value);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return text;
    }
}
