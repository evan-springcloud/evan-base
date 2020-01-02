package test.evan.springcloud.base.demo;


import org.evan.springcloud.base.service.demo.jdbc.DemoJdbc;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.evan.springcloud.base.support.MySQLTestCaseSupport;


/**
 * DemoJdbc Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 10, 2019</pre>
 */
public class DemoJdbcTest extends MySQLTestCaseSupport {

    @Autowired
    private DemoJdbc demoJdbc;

    /**
     * Method: notExists(Long id, String fieldText)
     */
    @Test
    public void testCheckFieldText() {
        boolean result = demoJdbc.notExists(null, "aa");

        LOGGER.info(">>>> testCheckFieldText, result is [{}]", result);
    }

} 
