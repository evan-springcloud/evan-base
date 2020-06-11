package org.evan.springcloud.base.config.smsvalidatecode;


import org.evan.springcloud.base.utils.SMSValidateCodeUtil;
import org.evan.springcloud.core.components.validatecode.ValidateCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evan.Shen
 * @since 2019-09-29
 */
@Configuration
public class SMSValidateCodeAutoConfiguration {

    @Bean
    public SMSValidateCodeUtil smsValidateCodeUtil(ValidateCode validateCodeStore) {
        SMSValidateCodeUtil smsValidateCodeUtil = new SMSValidateCodeUtil(validateCodeStore);
        return smsValidateCodeUtil;
    }
}
