package test.org.evan.springcloud.base.support;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 2017/9/20.
 *
 * @author evan.shen
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MongoDBTestBeansConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MongoDBTestCaseSupport {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
}
