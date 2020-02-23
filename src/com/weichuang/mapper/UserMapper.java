package com.weichuang.mapper;

import com.weichuang.pojo.User;
import com.weichuang.vo.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mapper接口名与mapper的xml配置文件名需要保持一致，且放于同包。
 */
public interface UserMapper {
    List<User> getAllUser();

    void deleteUserById(int id);

    void insertUser(User user);

    List<User> getUsersByQueryVo(QueryVo vo);

    int getUserCount();

    List<User> getUsersByNameAndSex(User user);
    //@Param 重新定义mapper.xml文件中可以识别的名称
    List<User> getUsersByNameAndSex(@Param("name") String name , @Param("sex") int sex);

    /*List<User> getUsersByIds(List<Integer> ids);*/
    List<User> getUsersByIds(Integer[] ids);
    List<User> getUsersByQueryVoIds(QueryVo vo);

    List<User> getUserOrderOBM();
}
