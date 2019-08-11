package test.org.evan.springcloud.base.jdbc;


import org.evan.springcloud.base.repository.jdbc.DemoJdbc;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.org.evan.springcloud.base.support.MySQLTestCaseSupport;

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
     * Method: checkFieldText(Long id, String fieldText)
     */
    @Test
    public void testCheckFieldText() {
         boolean result = demoJdbc.checkFieldText(null,"aa");

        LOGGER.info(">>>> testCheckFieldText, result is [{}]", result);
    }

} 
