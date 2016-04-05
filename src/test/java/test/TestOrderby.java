package test;

import com.webdm.common.tools.StringUtil;
import junit.framework.TestCase;
import net.csdn.mars.service.FetchService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 改改 on 2014/6/2.
 */
public class TestOrderby extends TestCase{

    public Map<String, Object> map(Object... key){

        if(key.length % 2 == 0){

            Map<String, Object> obj = new HashMap<String, Object>();

            Object mapKey = null;
            for(int i = 0; i < key.length; i++){

                if(i % 2 == 0){
                    mapKey = key[i];
                }else{

                    obj.put(StringUtil.toString(mapKey), key[i]);
                }
            }
            return obj;
        }
        return null;

    }
    public void show(List<Map<String, Object>> data){

        int i = 1;
        for(Map<String, Object> d : data){
            System.out.println("[" + i++ + "]" + d);
        }
    }
    @org.junit.Test
    public void testOrderby(){

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();


        list.add(map("id", 1, "name", "id1"));
        list.add(map("id", 0, "name", "id0"));
        list.add(map("id", 4, "name", "id4"));
        list.add(map("id", 2, "name", "id2"));
        list.add(map("id", 7, "name", "id7"));


        FetchService fetchService = new FetchService(null, null, null, null, null);


        fetchService.orderby(list, "asc", "name");

        show(list);

    }
}
