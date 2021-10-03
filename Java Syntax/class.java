
_______________

/* CLASS 类:
1. To run a file, must include MAIN method, however, compilation can be done without it
2. Method from other classes can be borrowed by using "." notation
3. Still, everything needs to be included in a "CLASS".
4. File 1 create a class and method, File 2 borrows the method.*/
public class DOG{
    public static void dognoise(){
        System.out.println("bark!");
    }
}
public class MAKE{
    public static void main(String[] args){
        DOG.dognoise();
    }
}