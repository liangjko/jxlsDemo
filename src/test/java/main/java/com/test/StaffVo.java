package main.java.com.test;

public class StaffVo {
    private String proid;
    private String proname;
    private String staffid;
    private  String staffname;

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }
    public StaffVo(){}

    public StaffVo(String proid,String proname,String staffid,String staffname){
        super();
        this.proid=proid;
        this.proname=proname;
        this.staffid=staffid;
        this.staffname=staffname;
    }
}