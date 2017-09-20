package cn.com.fhz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/9/19.
 */
@Controller
public class Sewies {
    @RequestMapping("sewise/index")
    public String getFlashM3u8(){
        return "sewise/demos/flash_m3u8";
    }
}
