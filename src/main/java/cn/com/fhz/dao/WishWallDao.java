package cn.com.fhz.dao;

import cn.com.fhz.entity.WishWall;
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
@CacheConfig(cacheNames = "wishWallCache")
public interface WishWallDao extends JpaRepository<WishWall,Long>,PagingAndSortingRepository<WishWall,Long>{

    @Cacheable(key = "#p0")
    @Query("select ww from WishWall ww where ww.userId=:userId")
    List<WishWall> listByUserId(@Param("userId") String userId);

}
