

_______________

/* OBJECT 对象:
1. A Java object is a member (also called an instance) of a Java class. 破案了，Object 就是 Instance!!!
2. An Object in Java is an instance of any class!! Classes can contain not just methods, but also DATA (OBJECT)
3. Instance variable / Non-static variable
4. Instance method / Non-static method
*/


/*****************[1] Static Version*/
public class DOG{
    public static void dognoise(int weight){
        if(weight < 10){
            System.out.println("yip!");
        }
        else if(weight < 30){
            System.out.println("wooof!");
        }
        else {
            System.out.println("bark!");
        }
    }
}
public class MAKE{
    public static void main(String[] args){
        DOG.dognoise(9);
    }
}


/*****************[2] Non-Static Version*/
public class DOG{
    public int weight;
    public DOG(int w){                /* known as "Constructor", pass input for later use */
        weight = w;
    }
    public void dognoise(){           /* here deletes the "static" */
        if(weight < 10){
            System.out.println("yip!");
        }
        else if(weight < 30){
            System.out.println("wooof!");
        }
        else {
            System.out.println("bark!");
        }
    }
}
public class MAKE{
    public static void main(String[] args){
        DOG d = new DOG(9);
        d.dognoise();
    }
}