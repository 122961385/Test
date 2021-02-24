package cn.sw.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //注入 dao
    @Autowired
    private BookDao bookDao;
}

