package cn.sw.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    //注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
