package org.lsh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.lsh.entity.User;

@Mapper
public interface UserMapper {

    @Select("select * from db_user where uid = #{uid}")
    User getUserById(Integer uid);
}
