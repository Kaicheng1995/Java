/**
* Map stores [key, value] pair, Map<key, value>   
* Map 和 Set 都是interface, 在创建时需要创建旗下implements他们的 class
*
* 创建: new HashMap<>(), new TreeMap<>()
* 添加: .put(key,value)
* 查找: .get(key)  返回value值，如果查不到就返回null
* 合并: map2.putAll(map1)
* 大小: .size()
* 空否: .isEmpty() 返回True/False
* 存在: .containsKey(), .containsValue() 返回True/False
* 删除: .remove(key) 删除对应key 的pairs
* 清空: .clear()
* 替换: .replace(key, newvalue) 替换为新的value, 并返回oldvalue
* 遍历: Interator, for loop, 都要用.ketSet()来循环喔
* key: .keySet() 返回key的一个集合
*/


import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.*;
import java.util.SortedMap;
import java.util.Iterator;


public class MapExamples {

    //helper method
    private static class Customer {
        String CustomerId;
        String Name;
        Customer(String c, String n) {
            CustomerId = c;
            Name = n;
        }

        String getCustomerID() {
            return CustomerId;
        }
    }

    public static void main(String[] args) {
        
        //创建HashMap()
        Map<String, Customer> map = new HashMap<>();
        //如果这里没有明确表明类型<>，那么可以添加任何类型

        Customer cus1 = new Customer("123", "Diana");
        Customer cus2 = new Customer("546", "John");

        //添加 以ID作为key值,customer为value值
        map.put(cus1.getCustomerID(), cus1);
        map.put(cus2.getCustomerID(), cus2);

        //查找
        System.out.println(map.get("123").Name);

        //创建
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashSet = new TreeMap<>();
        SortedMap sortedMap = new TreeMap();

        //合并
        Map<String, String> map1 = new HashMap<>();
        map1.put("123", "Jane");
        map1.put("456", "Peter");
        Map<String, String> map2 = new HashMap<>();
        map2.putAll(map1);

        //大小
        int s = map2.size();

        //存在
        boolean x = map2.containsKey("123");
        boolean y = map2.containsValue("Jane");

        //替换
        String oldvalue = map2.replace("123", "Alice");

        System.out.println("Using iterator:");
        //iterator遍历, 用key set来遍历
        Iterator<String> keyIterator = map2.keySet().iterator();
        while (keyIterator.hasNext()) {
            String nextKey = keyIterator.next();
            System.out.println(nextKey);  //打印key
            System.out.println(map2.get(nextKey));  //打印value
        }

        System.out.println("Using for loop:");
        //for loop遍历, 用key set来遍历
        for (String key : map2.keySet()) {
            System.out.println(key);
            System.out.println(map2.get(key));
        }
    }



}