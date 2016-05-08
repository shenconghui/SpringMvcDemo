package com.serviceprovider;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * Created by 1 on 2016/5/7.
 */
public class SimpleLogServiceFactory  implements ObjectFactory {
    public Object getObjectInstance(Object obj, Name name, Context ctx,
                                    Hashtable<?, ?> env) throws Exception {
        if(obj instanceof Reference){
            return new SimpleLogService();
        }
        return null;
    }


}
