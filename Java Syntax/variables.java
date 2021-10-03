
_______________

/* VARIABLES 变量:
1. Before Java variables can be used, they must be declared.
2. Java variables must have a specific type 
3. Java variable type can never be changed
4. Types are verified before the code even run 
*/



_______________

/* TYPES OF VARIABLES 变量类型:
8 primitive data types in Java:
1. byte
2. short
3. int
4. long
5. float
6. double 
7. boolean
8. char 

9. Reference type (包括array)

*/

public class HelloNumbers{
    public static void main(String[] args){
        int x = 0;
        while (x < 10){
            System.out.println(x);
            x = x + 1;
        }
    }
}



注意！！！！！当 primitive variable 被 method call的时候，它只是用了被 copy 的值，原值是不会变化的！！！





_______________
/* 
Local variables − Variables defined inside methods, constructors or blocks are called local variables. The variable will be declared and initialized within the method and the variable will be destroyed when the method has completed.

Instance variables (Non-Static) − Instance variables are variables within a class but outside any method. These variables are initialized when the class is instantiated. Instance variables can be accessed from inside any method, constructor or blocks of that particular class.

Class variables (Static!!) − Class variables are variables declared within a class, outside any method, with the static keyword.
*/



_______________

/* STATIC VS NON-STATIC VARIABLE:

1. Static variables should be accessed using the name of the class rather than a specific instance.
2. Every Static variable has same value when being accessed. */
public class Dog {
    public int weightInPounds;
    public static String binomen = "Canis familiaris";  //这个最好用 Dog.binomen 来取用，因为大家都是一样的, 都属于这个class, 所以也叫 class variables
    ...
}










_______________

/*REFERENCE VARIABLE DECLARATION:


1. There are 2 varieties of data types in Java, primitive and reference type.
2. When we declare a variable of any reference type, Java allocates a box of 64 bits, no matter what type of object.
3. The 64 bit box contains not the data about the walrus, but instead the address of the Walrus in memory.*/
*****************
Walrus someWalrus;  //creates a box of 64 bits
someWalrus = new Walrus(1000, 8.3); //creates a new Walrus, and the address is returned by the new operator, stored in the box
*****************
//example1: "a" will be changed
public class puzzle{
    public static void main(String[] args){
        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);
        System.out.println(b);

        int x = 5;
        int y;
        y = x;
        x = 2;
        System.out.println("x is: " + x);
        System.out.println("y is: " + y);
    }
}
*****************
//example2: "walrus" will be changed, "x" do not. 
public class PassByValueFigure {
    public static void main(String[] args) {
           Walrus walrus = new Walrus(3500, 10.5);
           int x = 9;                                //比如，这个就属于local variable

           doStuff(walrus, x);
           System.out.println(walrus);
           System.out.println(x);
    }
    public static void doStuff(Walrus W, int x) {
           W.weight = W.weight - 100;
           x = x - 5;
    }
    public static class Walrus {
      public double weight;                  //class content 1
      public double height;                  //class content 2
      public Walrus(double w, double h){     //constructor: enable input
         weight = w;
         height = h;
      }
   }
}