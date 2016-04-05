//package test;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import net.csdn.junit.BaseServiceTest;
//import net.csdn.mars.cache.Cache;
//import net.csdn.mars.cache.CacheCallBack;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by 改改 on 2014/5/28.
// */
//public class TestCache extends BaseServiceTest {
//
//    static {
//        initEnv(Cache.class);
//    }
//    @org.junit.Test
//    public void test(){
//
//        Cache c = findService(Cache.class);
//
//        List<String> ids = new ArrayList<String>();
//        ids.add("40");
//        ids.add("43");
//        List<Map<String, Object>> list = c.cache("blog", ids, "", "title,body,views,ups,downs,comments,id", new CacheCallBack(){
//
//            @Override
//            public JSONArray getData(String keys, String dataType, String fieldName) {
//                JSONArray jsonArray = new JSONArray();
//
//                String arr[] = keys.split(",");
//                for(String key : arr){
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("id", key);
//                    jsonObject.put("title", key + "_title");
//                    jsonObject.put("body", key + "_body");
//                    jsonObject.put("type", "blog");
//                    jsonObject.put("views", 10);
//                    //ups,downs,comments
//                    jsonObject.put("ups", 10);
//                    jsonObject.put("downs", 10);
//                    jsonObject.put("comments", 10);
//
//                    jsonArray.add(jsonObject);
//                }
//
//
//                return jsonArray;
//            }
//        }, false,false, null,0, false);
//
//        if(list != null && list.size() > 0){
//            System.out.println("数据" + list.size());
//            for(Map<String, Object> map : list){
//
//                System.out.println(JSONObject.toJSONString(map));
//            }
//        }else{
//            System.out.println("没有取到数据");
//        }
//    }
//}
