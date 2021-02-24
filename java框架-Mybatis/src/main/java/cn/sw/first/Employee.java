package cn.sw.first;


import org.apache.ibatis.type.Alias;

public class Employee {

    private Integer id;
    private String sIDNO;
    private String sName;
    private String sCafeID;
    private String sNbname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsIDNO() {
        return sIDNO;
    }

    public void setsIDNO(String sIDNO) {
        this.sIDNO = sIDNO;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCafeID() {
        return sCafeID;
    }

    public void setsCafeID(String sCafeID) {
        this.sCafeID = sCafeID;
    }

    public String getsNbname() {
        return sNbname;
    }

    public void setsNbname(String sNbname) {
        this.sNbname = sNbname;
    }


    public Employee(Integer id, String sIDNO, String sName, String sCafeID, String sNbname) {
        this.id = id;
        this.sIDNO = sIDNO;
        this.sName = sName;
        this.sCafeID = sCafeID;
        this.sNbname = sNbname;
    }
    public Employee(String sIDNO, String sName, String sCafeID, String sNbname) {
        this.sIDNO = sIDNO;
        this.sName = sName;
        this.sCafeID = sCafeID;
        this.sNbname = sNbname;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "sIDNO='" + sIDNO + '\'' +
                ", sName='" + sName + '\'' +
                ", sCafeID='" + sCafeID + '\'' +
                ", sNbname='" + sNbname + '\'' +
                '}';
    }
}
