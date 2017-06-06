package cn.com.fhz.dao;

import cn.com.fhz.entity.MerryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by woni on 17/5/30.
 */
@Component
public interface MerryUserDao extends JpaRepository<MerryUser,String>,PagingAndSortingRepository<MerryUser,String>{
}
