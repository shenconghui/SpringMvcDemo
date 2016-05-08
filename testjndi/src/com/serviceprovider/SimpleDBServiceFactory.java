package com.serviceprovider;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * Created by 1 on 2016/5/7.
 */
public class SimpleDBServiceFactory implements ObjectFactory {
    //根据Reference中存储的信息创建出SimpleDBService实例
    public Object getObjectInstance(Object obj, Name name, Context ctx,
                                    Hashtable<?, ?> env) throws Exception {
        if(obj instanceof Reference){
            Reference ref=(Reference)obj;
            String location=(String)ref.get("location").getContent();
            String state=(String)ref.get("state").getContent();
            SimpleDBService db= new SimpleDBService();
            db.setProperty(0, location);
            db.setProperty(1, state);
            return db;
        }
        return null;
    }
}
