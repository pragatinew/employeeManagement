package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Pragati on 2015/03/11.
 */
@Controller
public class LoginController {
    @RequestMapping("login")
    public ModelAndView getLoginForm(@RequestParam(required = false) String authFailed, String logout, String denied) {
        String message = "";
        if(authFailed != null) {
            message = "invalid username and password! try again...";
        } else if(logout != null) {
            message = "logged out successfully! login again to continue...";
        }
        else if(denied != null) {
            message = "access denied for the user";
        }
        return new ModelAndView("login","message", message);
    }

    @RequestMapping("user")
    public String geUserPage() {
        return "user";
    }

    @RequestMapping("admin")
    public String geAdminPage() {
        return "admin";
    }

    @RequestMapping("403page")
    public String ge403denied() {
        return "redirect:login?denied";
    }
}
