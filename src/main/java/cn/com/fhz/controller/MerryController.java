package cn.com.fhz.controller;

import cn.com.fhz.entity.Photo;
import cn.com.fhz.entity.WishWall;
import cn.com.fhz.service.PhotoService;
import cn.com.fhz.service.WishWallService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by woni on 17/5/20.
 */
@Controller
public class MerryController {


    @Autowired
    PhotoService photoService;

    @Autowired
    WishWallService wishWallService;


    @RequestMapping("/index/{userId}")
    public String returnIndex(@PathVariable(value = "userId",required = true)String userId, ModelMap map){


        map.addAttribute("host","localhost");



        if (StringUtils.isNotBlank(userId)){

            List<Photo> photos = photoService.listByUserId(userId);

            List<WishWall> wishWalls = wishWallService.listByUserId(userId);


            if (null!=photos&&photos.size()==12){
                for (int i = 0; i <photos.size() ; i++) {
                    map.addAttribute("photo"+i,photos.get(i));

                }
//                map.addAttribute("photo",photos);




            }
            if (null!=wishWalls&&wishWalls.size()>0){
                map.addAttribute("wishWalls",wishWalls);

            }

        }


        return "index";

    }

}
