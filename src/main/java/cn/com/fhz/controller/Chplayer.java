package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/9/18.
 */
@Controller
public class Chplayer {

    @RequestMapping("/chplayer/index")
    public String getIndex(){
        return "chplayer/index";
    }
}
