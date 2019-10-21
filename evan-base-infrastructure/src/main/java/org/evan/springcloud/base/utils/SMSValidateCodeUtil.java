package org.evan.springcloud.base.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.evan.libraries.utils.RandomDataUtil;
import org.evan.libraries.utils.StringUtil;
import org.evan.springcloud.core.utils.ValidateCodeStore;

/**
 * @author Evan.Shen
 * @since 2019-09-29
 */
@Slf4j
public class SMSValidateCodeUtil {

    private ValidateCodeStore validateCodeStore;

    public SMSValidateCodeUtil(ValidateCodeStore ValidateCodeStore) {
        this.validateCodeStore = ValidateCodeStore;

        log.info(">>>> {} inited", SMSValidateCodeUtil.class.getSimpleName());
    }

    public String send(String type, String mobile) {
        if (StringUtil.isBlank(type)) {
            type = "noType";
        }

        String keyStore = DigestUtils.sha256Hex(mobile);//生成用于存放验证码的cacheKey

        String code = RandomDataUtil.randomString(6);

        validateCodeStore.put("SMS" + type, keyStore, code);//将验证码存储在cache

        //TODO 发送短信

        log.info(">>>> 发送短信验证码:,type:[{}],mobile:[{}],code:[{}]", type, mobile, code);

        return code;
    }

    public String send(String mobile) {
        return send(null, mobile);
    }

    /**
     * 校验码是否正确
     *
     * @param validateCode
     * @return
     */
    public String validate(String type, String mobile, String validateCode) {
        if (StringUtil.isBlank(type)) {
            type = "noType";
        }

        String keyStore = DigestUtils.sha256Hex(mobile);//生成用于存放验证码的cacheKey

        log.info(">>>> 验证图片验证码:type[{}],mobile:[{}],validateCode[{}]", type, mobile, validateCode);

        boolean result = validateCodeStore.validate("SMS" + type, keyStore, validateCode);

        String returnV = null;
        if (result) {
            String tokenAfterValidate = RandomDataUtil.randomString(10);
            validateCodeStore.put("SMS" + type, keyStore, tokenAfterValidate);//将验证码存储在cache
            returnV = tokenAfterValidate;
        }

        return returnV;
    }

    public String validate(String mobile, String validateCode) {
        return validate(null, mobile, validateCode);
    }
}
