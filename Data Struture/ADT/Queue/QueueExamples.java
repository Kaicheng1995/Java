/**
* Queue是ADT，是一个interface，需要用class implementation来实现
* 
* 实现: LinkedList， ArrayDeque， Priority Queue
* 添加1: .add() 成功返回True，失败抛出异常 IllegalStateException
* 添加2: .offer() 成功返回True，失败返回 False，优于add()
* 删除1: .remove() 成功返回删除值，失败抛出异常
* 删除2: .poll() 成功返回删除值，失败返回null
* 查看:  .peek() 返回首位值
* 清空:  .clear()
* 大小:  .size()
* 查找:  .contains() 存在返回True  
* 遍历:  Iterator, for loop
*/


import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.PriorityQueue;


public class QueueExamples {
    public static void main(String[] args) {

        // 创建
        Queue<Customer> queue1 = new LinkedList<>();
        Queue<Customer> queue2 = new ArrayDeque<>();
        Queue<Customer> queue3 = new PriorityQueue<>();

        // 遍历1: Iterator
        Iterator<String> iterator = queue1.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next()
            System.out.println(next);
        }

        // 遍历2: for loop
        for (String next : queue1) {
            System.out.println(next);
        }

    }
}