package org.evan.springcloud.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evan.Shen
 * @since 2019-08-01
 */
@RestController
public class DemoController {

    @Autowired
    private Environment environment;

    @GetMapping("testConfig/{configName}")
    public String testConfig(@PathVariable("configName") String configName) {
        return environment.getProperty(configName, "undefinded");
    }
}
