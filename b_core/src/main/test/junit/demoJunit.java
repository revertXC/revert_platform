package junit;

import com.revert.core.RevertApplication;
import com.revert.core.demo.queryDB.jdbcTemplate.service.DemoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * junit 测试基类
 */
//SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
//启动类
@SpringBootTest(classes = RevertApplication.class)
//web项目支持
@WebAppConfiguration
public class demoJunit {

    @Autowired
    private DemoUserService userService;

    @Test
    public void runJunitTest()
    {
        System.out.println(userService.selectAllCount());
    }


}
