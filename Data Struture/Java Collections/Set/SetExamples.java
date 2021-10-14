/**
* Set: 没有顺序，元素不重复
* List：有顺序，元素可重复
*/


/**
* 创建: new HaseSet/TreeSet/Set.of()
* 添加: .add() 返回True/False, .addAll()括号里添加一个set中的所有元素，重复的不添加
* 删除: .remove() 返回True/False, removeAll()括号里删除一个set中的所有元素，重复的不删除
* 清空: .clear() 清空所有元素
* 保留: .retainAll() 只保留两个集合的交集元素
* 遍历: Iterator, for loop
* 个数: .size()
* 空否: .isEmpty() 返回True/False
* 查找: .contains() 返回True/False
* List转换: List.addAll(set)
*/


import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class SetExamples {

    public static void main(String[] args) {
        // instatiate Set时，需要用Set interface下面的class
        // 创建: 最常用的是 HashSet 和 TreeSet
        Set<String> set1 = new HashSet<>();  //<>去掉就不设定特定类型

        // 添加: 返回 True/False
        boolean added = set1.add("Hello");
        Set<String> set2 = Set.of("Hello", "World");  //创建一个新Set
        System.out.println(set2);


        System.out.println("Using Iterator:");
        //遍历: 使用Iterator
        Set<String> set3 = Set.of("Hello", "World", "1", "2", "3");
        Iterator<String> iterator = set3.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next); //使用Set.of()打印出来顺序是随机的
        }

        System.out.println("Using for loop:");
        //遍历: 使用for loop
        Set<String> set4 = new TreeSet<>();
        set4.add("Hello");
        set4.add("World");
        set4.add("1");
        set4.add("2");
        set4.add("3");
        for (String element : set4) {
            System.out.println(element); //TreeSet结构，就是有顺序的
        }

        //删除
        boolean remove = set4.remove("3");
        set4.addAll(Set.of("1", "9", "abc")); //因为1重复了，所以只添加9和abc
        set4.removeAll(Set.of("1", "8")); //因为8没有，所以只删除1

        //保留
        set4.retainAll(Set.of("2")); //只剩下2了

        //个数
        System.out.println(set4.size());

        //空否
        System.out.println(set4.isEmpty());

        //查找
        System.out.println(set4.contains("2"));

        //转换为List
        List<String> list = new ArrayList<>();
        list.addAll(set4);
        System.out.println(list);

    }

}

