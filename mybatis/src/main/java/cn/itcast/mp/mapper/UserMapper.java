package cn.itcast.mp.mapper;

import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;

public interface UserMapper extends BaseMapper<User> {

    //在UserMapper接口类中新增findById方法
    public User findById(Long id);

    /**
     * 根据 ID 删除
     * @param id 主键ID
     */
    int deleteById(Serializable id);



}
