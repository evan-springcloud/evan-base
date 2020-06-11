package org.evan.springcloud.base.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Evan.Shen
 * @since 2019-09-28
 */
public class BusinessAuthUtil {
    public static String getSignForLogin(String account, String pwdHash, String random) {
        String sign = DigestUtils.sha256Hex(account + random + pwdHash);
        return sign;
    }
}
