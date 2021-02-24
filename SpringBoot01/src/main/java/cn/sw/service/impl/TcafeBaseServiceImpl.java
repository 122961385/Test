package cn.sw.service.impl;

import cn.sw.entity.TcafeBase;
import cn.sw.mappers.TcafeBaseMapper;
import cn.sw.service.TcafeBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TcafeBaseServiceImpl  implements TcafeBaseService {

    @Autowired
    private TcafeBaseMapper tcafeBaseMapper;

    @Override
    public TcafeBase queryTcafeBaseById(int id) {
        return tcafeBaseMapper.queryTcafeBaseById(id);
    }
}
