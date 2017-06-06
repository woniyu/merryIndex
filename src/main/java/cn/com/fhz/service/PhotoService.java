package cn.com.fhz.service;

import cn.com.fhz.dao.PhotoDao;
import cn.com.fhz.entity.Photo;
import cn.com.fhz.entity.WishWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by woni on 17/5/30.
 */
@Service
public class PhotoService {
    @Autowired
    PhotoDao photoDao;

    public List<Photo> listByUserId(String userId){
       return photoDao.findAllPhotoByUserId(userId);
    }




}
