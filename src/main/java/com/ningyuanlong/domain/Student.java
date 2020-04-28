package com.ningyuanlong.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tony on 2020/4/25.
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String sID;

    @Column
    private String sname;

    @Column
    private String sex;

    @Column
    private Date enrolTime;

    @Column
    private String departmentID;

    @Column
    private String type;

    @Column
    private String riskLevel;

    @Column
    private String location;

    @Column
    private String flag;

    @Column
    private String memo;

    @Column
    private String valid;


    public Student(String sID, String sname, String sex, Date enrolTime, String departmentID, String type, String riskLevel, String location, String memo, String valid) {
        this.sID = sID;
        this.sname = sname;
        this.sex = sex;
        this.enrolTime = enrolTime;
        this.departmentID = departmentID;
        this.type = type;
        this.riskLevel = riskLevel;
        this.location = location;
        this.memo = memo;
        this.valid = valid;
    }

    public Student() {
    }

    public Student(String sID, String sname, String sex, Date enrolTime, String departmentID, String type, String riskLevel, String location, String flag, String memo, String valid) {
        this.sID = sID;
        this.sname = sname;
        this.sex = sex;
        this.enrolTime = enrolTime;
        this.departmentID = departmentID;
        this.type = type;
        this.riskLevel = riskLevel;
        this.location = location;
        this.flag = flag;
        this.memo = memo;
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getEnrolTime() {
        return enrolTime;
    }

    public void setEnrolTime(Date enrolTime) {
        this.enrolTime = enrolTime;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
