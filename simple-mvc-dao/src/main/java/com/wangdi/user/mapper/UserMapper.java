package com.wangdi.user.mapper;

import com.wangdi.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by D on 2017/5/22.
 */
public interface UserMapper {

    @Select("SELECT * FROM TB_USER WHERE loginname = #{loginname} and password = #{password}")
    User findWithLoginnameAndPassword(@Param("loginname") String loginname,
                                      @Param("password") String password);

}
