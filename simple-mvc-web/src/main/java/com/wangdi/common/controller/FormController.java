package com.wangdi.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by D on 2017/5/22.
 */
@Controller
public class FormController {

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }

}
