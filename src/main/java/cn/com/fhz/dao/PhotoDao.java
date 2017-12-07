package cn.com.fhz.dao;

import cn.com.fhz.entity.Photo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by woni on 17/5/30.
 */
@Component
@CacheConfig(cacheNames = "photoCache")
public interface PhotoDao extends JpaRepository<Photo,Long>,PagingAndSortingRepository<Photo,Long> {

    @Cacheable(key = "#p0")
    @Query("select p from Photo p where p.userId=:userId")
    List<Photo> findAllPhotoByUserId(@Param("userId") String userId);

}
