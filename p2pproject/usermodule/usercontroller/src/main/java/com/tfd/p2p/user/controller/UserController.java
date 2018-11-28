package com.tfd.p2p.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tfd.p2p.commons.beans.ResultsBean;
import com.tfd.p2p.user.pojo.User;
import com.tfd.p2p.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public ResultsBean register(@Valid User user, BindingResult bindingResult,String phoneCode,String picCode,String repeatPasswprd){
        ResultsBean resultsBean=new ResultsBean();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String objectName = fieldError.getObjectName();
                String defaultMessage = fieldError.getDefaultMessage();
                System.out.println(objectName+"========>"+defaultMessage);
            }
            resultsBean.setData(bindingResult.getAllErrors());
            return resultsBean;
        }


        try {

            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultsBean;
    }
}
