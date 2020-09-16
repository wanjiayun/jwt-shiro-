package com.wanjiayun.shirojwt.controller;


import com.wanjiayun.shirojwt.auth.JWTUtil;
import com.wanjiayun.shirojwt.entity.User;
import com.wanjiayun.shirojwt.exception.UnauthorizedException;
import com.wanjiayun.shirojwt.service.UserService;
import com.wanjiayun.shirojwt.util.JsonResult;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired 
    private UserService userService;



    @PostMapping("/login")
    public JsonResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        User user = userService.getUserDetailInfoByUserName(username);
        if (user.getPass().equals(password)) {
            return new JsonResult(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/article")
    public JsonResult article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new JsonResult(200, "You are already logged in", null);
        } else {
            return new JsonResult(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public JsonResult requireAuth() {
        return new JsonResult(200, "需要认证,不需要权限", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public JsonResult requireRole() {
        return new JsonResult(200, "需要角色admin", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"all", "half"})
    public JsonResult requirePermission() {
        return new JsonResult(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JsonResult unauthorized() {
        return new JsonResult(401, "Unauthorized", null);
    }
}
