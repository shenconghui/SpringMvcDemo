package com.serviceprovider;

import com.service.DBService;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

/**
 * Created by 1 on 2016/5/7.
 */
public class SimpleDBService implements DBService,Referenceable {
    private String location="jdbc:mysql://localhost:3306/netctoss";//数据库服务属性之一：数据库位置
    private String state="start"; //数据库服务属性之二：数据库状态
    public Reference getReference() throws NamingException {
        //Reference是对象的引用，Context中存放的是Reference，为了从Reference中还原出对象实例，
        //我们需要添加RefAddr，它们是创建对象实例的线索。在我们的SimpleDBService中，location和state是这样两个线索。
        Reference ref=new Reference(getClass().getName(),SimpleDBServiceFactory.class.getName(),null);
        ref.add(new StringRefAddr("location",location));
        ref.add(new StringRefAddr("state",state));
        return ref;
    }

    public void accessDB() {
        if(state.equals("start"))
            System.out.println("we are accessing DB.");
        else
            System.out.println("DB is not start.");
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    public void setProperty(int index,String property){
        if(index==0)
            location=property;
        else
            state=property;
    }

}
