/* COMMAND LINE:
1. String[] args means creating an array of String called args*/
public class argsdemo{
    public static void main(String[] args){
        int N = args.length;
        int i = 0;
        int sum = 0;
        while(i < N){
            sum = sum + Integer.parseInt(args[i]);
            i = i + 1;
        }
        System.out.println(sum);
    }
}


/* LIBRARY:
1. Java Library
2. The Princeton Standard Library: http://introcs.cs.princeton.edu/java/stdlib/
3. Community*/


/* CONSTRUCTOR:
To initalize an instance of the class,and it's like creating an access to place INPUT for the class.
IN SHORT: for "new", initialize new content.


/* PUBLIC & PRIVATE & NESTED CLASS (See codes at SLList.java)
1. Private variables and methods, or constructors can only be accessed by code inside the same .java file (ATTENTION HERE)
2. It's a simple way to signal other programmers you should not use this, and soft restriction by the compiler so you cannot mess with it
3. A nested class which is STATIC can't access any of the outer class's stuff.

Why use PRIVATE to restrict access?
Hide implementation details from users of your class:
                1. Less for user of class to understand.
                2. Safe for you to change private methods (implementation).
                
 
 
 

/* MEMORY:
/** give a memory box of 32 bits that stores ints */
int x;

/** give a memory box of 64 bits that stores Walrus reference */
Walrus w1;

/** give a memory box of 64 bits that stores Walrus references and also give us 96 bits for storing the int size(32 bits)
 and double tuskSize(64 bits) of our Walrus */
Walrus w2 = new Walrus(30, 5.6);





