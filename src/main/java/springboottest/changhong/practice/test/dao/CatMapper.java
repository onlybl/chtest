package springboottest.changhong.practice.test.dao;

import springboottest.changhong.practice.test.pojo.DO.Cat;

public interface CatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cat record);

    int insertSelective(Cat record);

    Cat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);
}