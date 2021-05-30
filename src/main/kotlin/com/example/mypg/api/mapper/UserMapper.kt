package com.example.mypg.api.mapper

import com.example.mypg.api.dto.UserDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select("""
        SELECT userid,name,password,mailaddress,zipcode,address1,address2,address3,telno,authority,insdate,upddate 
        FROM
            user_tbl
        WHERE
            userid = #{userid} and password = #{password}
    """)
    fun getMyUser(userid: String, password: String): UserDto

    @Select("""
        SELECT SQL_CALC_FOUND_ROWS userid,name,password,mailaddress,zipcode,address1,address2,address3,telno,authority,insdate,upddate 
        FROM
            user_tbl limit #{limit} offset #{offset} 
    """)
    fun getUserList(limit: Long, offset: Long): List<UserDto>
}