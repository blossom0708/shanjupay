package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//
// https://blog.csdn.net/javamendou/article/details/131403440
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    // 根据id查询
    @Test
    public void testFindById() {
        User user = userMapper.findById(2L);
        System.out.println(user);
    }

    // 根据id删除
    @Test
    public void testDeleteById() {
        //执行删除操作
        int result = this.userMapper.deleteById(4L);
        System.out.println("result = " + result);
    }



}
