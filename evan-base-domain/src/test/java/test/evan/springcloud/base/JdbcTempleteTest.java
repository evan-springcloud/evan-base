package test.evan.springcloud.base;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import test.evan.springcloud.base.support.MySQLTestCaseSupport;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTempleteTest extends MySQLTestCaseSupport {

    @Autowired
    @Qualifier("jdbcTemplateNo1")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        final String sql = "insert into demo(FIELD_TEXT)values(?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, new String[]{"ID"});
                ps.setString(1, "我的");
                return ps;
            }
        }, keyHolder);

        int id = keyHolder.getKey().intValue();

        //		/hibernateTemplate.load(entityClass, id)

        LOGGER.info(">>>> testInsert, pk is [{}]", id);

    }
}
