package cn.sw.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TcafeBaseDaoImpl implements TcafeBaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TcafeBase> query() {
        //1 创建 sql 语句
        String sql = "select * from tcafebase";
        //2 调用方法实现
//        Object[] args = {book.getUserId()};
        List<TcafeBase> tcafeBaseList = jdbcTemplate.queryForList(sql, TcafeBase.class);
        return tcafeBaseList;
    }
}
