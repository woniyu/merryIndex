package cn.com.fhz.dao;

import cn.com.fhz.entity.WishWall;
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
public interface WishWallDao extends JpaRepository<WishWall,Long>,PagingAndSortingRepository<WishWall,Long>{

    @Query("select ww from WishWall ww where ww.userId=:userId")
    List<WishWall> listByUserId(@Param("userId") String userId);

}
