/**
* 创建: LinkedList, ArrayList
* 添加: .add(item)    返回true/false
* 删除: .remove(index) 返回被删掉的值
* 查找: .get(index)  返回该位置的值
* 大小: .size()
* 遍历: Iterator, for loop
* 清空: .clear()
*/


// package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class ListExamples {

    public static void main(String[] args) {
        
        //创建
        List<String> mylist = new ArrayList<>();

        //添加
        System.out.println(mylist.add("Object 0"));
        mylist.add("Object 1");
        mylist.add("Object 2");

        //删除
        mylist.remove(0);

        //查找
        String head = mylist.get(0);
        int s = mylist.size();

        System.out.println("Iterator:");
        //遍历: Iterator
        Iterator<String> iterator = mylist.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("for loop:");
        //遍历: for loop
        for (String item : mylist) {
            System.out.println(item);
        }

        System.out.println("standard for loop:");
        for (int i = 0; i < mylist.size(); i++) {
            System.out.println(mylist.get(i)); // 这个对于linkedlist来说很慢
        }

        //清空
        mylist.clear();

        
    }
}