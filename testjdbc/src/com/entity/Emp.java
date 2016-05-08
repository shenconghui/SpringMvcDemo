package com.entity;

import java.sql.Date;

/**
 * Created by 1 on 2016/5/7.
 */
public class Emp {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private double comm;
    private String job;
    private Date hiredate;
    private int deptno;
    private String descr;

    public Emp() {
    }

    public Emp(int id, String name, String gender, double salary, double comm,
               String job, Date hiredate, int deptno, String descr) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.comm = comm;
        this.job = job;
        this.hiredate = hiredate;
        this.deptno = deptno;
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", comm=" + comm +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", deptno=" + deptno +
                ", descr='" + descr + '\'' +
                '}';
    }
}
