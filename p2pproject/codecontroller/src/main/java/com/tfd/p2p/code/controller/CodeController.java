package com.tfd.p2p.code.controller;

import cn.dsna.util.images.ValidateCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/code")
public class CodeController {
    @RequestMapping("/imageCode")
    public void getPicCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode validateCode=new ValidateCode(240,80,4,100);
        BufferedImage buffImg = validateCode.getBuffImg();
        String code = validateCode.getCode();
        Cookie[] cookies = request.getCookies();
        boolean haveCookie=false;
        String redisKey=null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                boolean equals = "picCookieCode".equals(cookie.getName());
                if (equals) {
                    haveCookie=true;
                    redisKey = cookie.getValue();
                    break;
                }
            }
        }
        if (!haveCookie){
            redisKey = UUID.randomUUID().toString();
            Cookie cookie=new Cookie("picCookieCode", redisKey);
            response.addCookie(cookie);
        }

        ImageIO.write(buffImg, "jpg", response.getOutputStream());
    }
}
