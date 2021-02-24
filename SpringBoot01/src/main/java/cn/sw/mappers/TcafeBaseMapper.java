package cn.sw.mappers;

import cn.sw.entity.TcafeBase;
import org.apache.ibatis.annotations.Param;

public interface TcafeBaseMapper {
    TcafeBase queryTcafeBaseById(@Param("id") int id);
}
