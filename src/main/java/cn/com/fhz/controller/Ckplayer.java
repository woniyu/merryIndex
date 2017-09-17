package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by woni on 17/9/17.
 */
@Controller
@RequestMapping("ckplayer")
public class Ckplayer {

    @RequestMapping("index")
    public String returnIndex(){
        return "ckplayer/demo3";
    }
}
