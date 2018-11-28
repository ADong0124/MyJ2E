package com.tfd.p2p.user.mapper;

import com.tfd.p2p.user.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    @Insert("insert into member_user (id, name, password, passwordSalt, phone) values (#{user.id},#{user.name},#{user.password},#{user.passwordSalt},#{user.phone})")
    void addUser(@Param("user") User user);
}
