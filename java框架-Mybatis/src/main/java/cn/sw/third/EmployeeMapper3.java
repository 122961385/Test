package cn.sw.third;

import cn.sw.first.Employee;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper3 {
//param1 param2
    public Employee getEmployeeByIdANDsIDNO(@Param("id") int id, @Param("sIDNO") String sIDNO);

    public Employee getEmployeeById(int id);

    public Long addEmp(Employee employee);

    public Long updateEmp(Employee employee);

    public Long delEmpById(int id);

    @MapKey("id")
    public Map<Integer,Employee> getEmpByIdReturnMap(Integer id);

    public Map<String,Object> getEmpByIdresultType(int id);

}
