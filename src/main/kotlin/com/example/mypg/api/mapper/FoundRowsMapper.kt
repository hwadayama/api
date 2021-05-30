package com.example.mypg.api.mapper

import com.example.mypg.api.dto.FoundRowsDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface FoundRowsMapper {

    @Select("""
        SELECT FOUND_ROWS() 
    """)
    fun getFoundRows(): FoundRowsDto
}