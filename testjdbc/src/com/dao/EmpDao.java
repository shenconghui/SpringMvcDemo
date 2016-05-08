package com.dao;

import com.entity.Emp;
import com.util.DBUtility;

import java.sql.*;




/**
 * Created by 1 on 2016/5/7.
 */
public class EmpDao {
    public void findAll(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netctoss","root","shen123456");
            //con = DBUtility.openConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from emp ");
            ResultSetMetaData meta = rs.getMetaData();
            int counnt = meta.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= counnt; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }

        }catch (ClassNotFoundException e){
           System.out.println("驱动类无法找到！");
           throw new RuntimeException(e);
        }
          catch (SQLException e){
            System.out.println("数据库访问异常！");
            throw new RuntimeException(e);
        } finally {
           try{
               if (rs != null){
                   rs.close();
               }

               if (stmt != null){
                   stmt.close();
               }
              if (con != null){
                  con.close();
              }
          }catch (SQLException e){
              System.out.println("关闭连接时发生异常！");
               //System.out.println("释放资源时发生异常！");
           }
           // DBUtility.closeConnectipn(con);
        }
    }

    public void add(Emp emp){

        Connection con = null;
        Statement stmt = null;
        int flag = -1;

        String sql = "insert into emp(id,name,gender,salary,comm,job,hiredate,deptno,descr)" +
                "values("+ emp.getId()+ ",'"+emp.getName() + "'," + "'"+emp.getGender()
                +"',"+emp.getSalary() +","+emp.getComm() +",'"+emp.getJob()+"',"
                +"to_date('"+emp.getHiredate()+",'yyyy-MM-dd'),"+emp.getDeptno()+",'"+emp.getDescr()+")";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netctoss","root","shen123456");
            stmt = con.createStatement();
            flag = stmt.executeUpdate(sql);
            if (flag >0 ){
                System.out.println("新增记录成功！");
            }
        }catch (ClassNotFoundException e){
            System.out.println("驱动类无法找到！");
            throw new RuntimeException(e);
        } catch (SQLException e){
            System.out.println("数据库访问异常！");
            throw new RuntimeException(e);
        }finally {
            try{
                if (stmt != null){
                    stmt.close();
                }
                if (con != null){
                    con.close();
                }
            }catch (SQLException e){
                System.out.println("关闭连接时发生异常！");
            }
        }

    }

    public static void main(String[] args){
       // Date date = new Date("2001-12-02","yyyy-MM-dd");
        EmpDao dao = new EmpDao();
        Emp emp = new Emp(6,"小华","女",4000,100,"dba",null,3,null);
        //dao.findAll();
        dao.add(emp);
    }
}
