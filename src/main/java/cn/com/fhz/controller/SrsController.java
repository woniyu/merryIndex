package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/9/20.
 */
@Controller
public class SrsController {
    @RequestMapping("srs/index")
    public String getIndex(){
        return "srs/play";
    }
}
