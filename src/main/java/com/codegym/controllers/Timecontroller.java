package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class Timecontroller {

    @GetMapping("/worldclock")
    public String getByTimeZone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh")String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();

        TimeZone locate = TimeZone.getTimeZone(city);
        long locate_time = date.getTime() + (locate.getRawOffset()-local.getRawOffset());
        date.setTime(locate_time);
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);
        return "index";
    }
}
