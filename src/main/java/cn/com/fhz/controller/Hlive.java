package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by woni on 17/9/17.
 */
@Controller
public class Hlive {
    @RequestMapping("hlive/index")
    public String getIndex(){
        return "hlive/demo";
    }
}
