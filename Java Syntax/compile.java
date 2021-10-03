/*Foundations of Java*/
/* textbook url:https://joshhug.gitbooks.io/hug61b/content/chap1/chap12.html */ 


/* JAVA的书写规则
1. All codes live in a class
2. The code that is run is inside of a method call main, which is declared as public static void main(String[] args)
3. Use braces {} to denote the begining and end of codes
4. Statements must be end with semicolons;
*/

/* JAVA的编译过程
Hello.java - javac(compiler) - Hello.class - java(Interpreter) - Stuff
Q: Why make a class file at all?
1. .class file has been checked, distributed code is safer.
2. .class file are simpler for machine to execute.
3. Protect your intellectual property.
*/

public class HelloWorld {
  public static void main(string[] args) {
    System.out.println("hello world");
  }
}
