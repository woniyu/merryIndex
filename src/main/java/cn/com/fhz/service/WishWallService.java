package cn.com.fhz.service;

import cn.com.fhz.dao.WishWallDao;
import cn.com.fhz.entity.WishWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by woni on 17/5/30.
 */
@Service
public class WishWallService {
    @Autowired
    WishWallDao wishWallDao;

    public List<WishWall> listByUserId(String userId){
        return wishWallDao.listByUserId(userId);
    }

    public Integer save(WishWall wishWall){
        WishWall wall = wishWallDao.save(wishWall);
        if (null!=wall.getId()){
           return 1;
        }else return 0;
    }


}
