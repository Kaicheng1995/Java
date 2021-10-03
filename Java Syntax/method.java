_______________

/* STATIC VS NON-STATIC METHOD 


1. Static Method (a.k.a Class Method):
are invoked using the class name!!!!

2. Non-Static Method (a.k.a Instance Method):
are invoked using an instance name!!!!


/*****************[1] Implement maxDog as a Static Method*/
public static Dog maxDog(Dog d1, Dog d2) {
    if (d1.weightInPounds > d2.weightInPounds) {           /*In this class, we have both instance and static methods*/ 
        return d1;
    }
    return d2;
}
Dog d = new Dog(15);
Dog d2 = new Dog(100);
Dog.maxDog(d, d2);


/*****************[2] Implement maxDog as a Non-Static Method*/
public Dog maxDog(Dog d2) {
    if (this.weightInPounds > d2.weightInPounds) {
        return this;
    }
    return d2;
}
Dog d = new Dog(15);
Dog d2 = new Dog(100);
d.maxDog(d2);


          

非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！
______________________________________________________________________________________________
/* NOTICE:
1. A variable or method defined in a class is also called a member of that class(a.k.a object)
2. Static members are accessed using class name
3. Non-static members cannot be invoked using class name
4. Static methods should access instance variables via a special instance. e.g. d1*/ 
______________________________________________________________________________________________

非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！非常重要！