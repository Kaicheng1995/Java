/**
* 实现: Stack
* 添加: .push()
* 删除: .poll() 成功返回删除的值
* 查看: .peek() 查看最外层的值
* 查找: .search() 返回index，最外层是1，没有就是-1
* 遍历: Iterator, for loop
*/


import java.util.

public class StackExamples {
    public static void main(String[] args) {
        
        // 实现
        Stack<String> stack = new Stack<>();

        // 添加
        stack.push("one");
        stack.push("two");

        // 查找（index = 2）
        int index = stack.search("one");

        // 遍历 Iterator
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 遍历 for loop
        for (String next : stack) {
            System.out.println(next);
        }

    }
}
