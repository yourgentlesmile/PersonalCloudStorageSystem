package indi.group.pcss.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import indi.group.pcss.model.User;
import indi.group.pcss.model.UserInformation;
import indi.group.pcss.services.IUserInformationService;
import indi.group.pcss.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Resource
    private IUserInformationService userInformationService = null;
    @Resource
    private IUserService userService = null;
    static{
        
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void Test_A_Insert(){
        User user = new User(0, "test", "order1");
        UserInformation userInformation = new UserInformation(0, "test", 66666, "realtest", "emailtest", 
                "telephonetest", "introductiontest", "avatartest", new Timestamp(new Date().getTime()), 66666, 66666);
        int result = userService.registerUser(user, userInformation);
        assertEquals(result, 4);
    }
    @Test
    
    public void Test_B_Select(){
        User userdata = userService.selectByUsername("test");
        logger.debug(userdata.getUserId()+"");
        User user = new User(0, "test", "order1");
        assertEquals(user.getUsername(), userdata.getUsername());
        assertEquals(user.getPassword(), userdata.getPassword());
    }
    @Test
    public void Test_C_Modify(){
        User userdata = userService.selectByUsername("test");
        logger.debug(userdata.toString());
        userdata.setUsername("testmodify");
        int result = userService.modifyUser(userdata);
        assertEquals(result, 1);
        userdata = userService.selectByUsername("testmodify");
        assertEquals("testmodify", userdata.getUsername()); 
    }
    @Test
    public void Test_D_Delete(){
        User userdata = userService.selectByUsername("testmodify");
        int result = userService.deleteByUserId(userdata.getUserId());
        assertEquals(1, result);
    }
    @Test
    public void Test_Z_DeleteAddon(){
        userInformationService.deleteByUserId(0);
    }
}
