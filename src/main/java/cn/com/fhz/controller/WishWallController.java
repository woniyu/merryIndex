package cn.com.fhz.controller;

import cn.com.fhz.entity.ResponseEntity;
import cn.com.fhz.entity.WishWall;
import cn.com.fhz.service.PhotoService;
import cn.com.fhz.service.WishWallService;
import cn.com.fhz.utils.WebMiscMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by woni on 17/6/1.
 */
@Controller
@RequestMapping("wishWall")
public class WishWallController {

    @Autowired
    WishWallService wishWallService;

    @RequestMapping("add")
    public String addWishWall(@RequestParam(name = "userId",required = true,defaultValue = "1")String userId,
                            @RequestParam(name = "content",required = true,defaultValue = "1")String content,
                            HttpServletResponse response){

        WishWall wall = new WishWall();

        wall.setUserId(userId);
        wall.setContent(content);
        wall.setCreateTime(new Date());


        Integer save = wishWallService.save(wall);
        if (save>0){
            WebMiscMethod.writeJson(response,new ResponseEntity(0,"保存成功"));
        }else WebMiscMethod.writeJson(response,new ResponseEntity(1,"保存失败"));


        return null;
    }
}
