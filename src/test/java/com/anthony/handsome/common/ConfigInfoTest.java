package test.com.anthony.handsome.common; 

import com.anthony.handsome.common.ConfigInfo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* ConfigInfo Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 12, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigInfo.class})
public class ConfigInfoTest { 

    @Autowired
    private ConfigInfo configInfo;

/** 
* 
* Method: setCounterExcludes(String counterExcludes) 
* 
*/ 
@Test
public void testGetSetCounterExcludes() throws Exception { 

    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    System.out.println(configInfo.getCounterExcludes());
} 


} 
