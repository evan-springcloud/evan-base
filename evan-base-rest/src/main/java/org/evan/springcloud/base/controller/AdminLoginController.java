package org.evan.springcloud.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.RestResponse;
import org.evan.libraries.web.utils.HttpUtil;
import org.evan.springcloud.core.oauth.LoginAccountWebSession;
import org.evan.springcloud.core.oauth.LoginAdmin;
import org.evan.springcloud.core.oauth.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Evan.Shen
 * @since 2020-11-10
 */
@RestController
@RequestMapping("admin")
@Slf4j
@Api(description = "登录和退出")
public class AdminLoginController {
    @Autowired
    private LoginAccountWebSession session;

    @ApiOperation(value = "登录", notes = "登录接口参数中不传递密码，用密码生成sign，再传递该sign即可<br>返回：SUCCESS:成功；ACCOUNT_OR_PWD_WRONG:账号密码错误；ACCOUNT_FROZENED:账号被冻结")
    @PostMapping("login")
    public RestResponse<LoginAdmin> login(
            HttpServletRequest request,
            @ApiParam(value = "账号", required = true) @RequestParam("account") String account,
            @ApiParam(value = "随机数，内容数字或字符串，最大长度40，随机数生产方式不限", required = true) @RequestParam("random") String random,
            @ApiParam(value = "签名，算法：sha256(account+random+sha1(密码明文))", required = true) @RequestParam("sign") String sign,
            @ApiParam("图片验证码，只有当登录失败3次之后才需要输入验证码") @RequestParam(name = "imgValidateCode", required = false) String imgValidateCode

    ) {

        LoginAdmin loginAdmin = new LoginAdmin();

        loginAdmin.setId(1L);
        loginAdmin.setAccount(account);
        loginAdmin.setRemoteAddr(HttpUtil.getRemoteAddr(request));

        session.save(loginAdmin);

        return RestResponse.create(loginAdmin);
    }

    @ApiOperation(value = "退出", notes = "")
    @PostMapping("logout")
    public RestResponse logout(HttpServletRequest request) {
        session.remove(request);
        return RestResponse.create();
    }
}
