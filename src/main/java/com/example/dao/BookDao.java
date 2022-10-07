package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Book;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 方式二 使用mybatis， extends BaseMapper<Book>，常规类已经封装有了
@Mapper
public interface BookDao extends BaseMapper<Book> {
}


////方式一：常规写法，定义各种接口
//@Mapper
//public interface BookDao {
//
//    @Select("select * from t_book where id = #{id}")
//    Book getById(Integer id);
//}
