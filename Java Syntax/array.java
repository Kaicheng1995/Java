_______________


/* ARRAY */
//1. A variable of array type holds a reference to an object*/
int[] x;
Planet[] planets;

//2. Instantiate an array
int[] x = new int[]{0, 1, 2, 95, 4};
                                    /*TIPS:
                                      - creating 64 bit box for storing an int array address.(Declaration)
                                      - cearting a new object, in this case an int array.(Instantiation)
                                      - Put the address of the new object into the 64 bit box.(Assignment)
                                      - Instantiated objects can be lost if reassigning to something else.

//example: First, use the keyword to create an array that can hold 2 objects.
//Then use new again for each object you want to put in the array.*/
DOG[] dogs = new DOG[2];
dogs[0] = new DOG(9);
dogs[1] = new DOG(19);
dogs[0].dognoise();

/** Arrays are s special kind of object which consists of a numbered sequence of memory boxes.
1. To get ith item of array A, use A[i]
2. A fixted integer length
3. Same type of value
4. All numbered 0 through length-1
5. It's a reference variable
6. It's like a class that has instance variables(like x.length)
 */

// create array containing 3 int boxes, each container gets a default value
y = new int[3];
// ceaate array containing 1,2,3,4,5 integers
x = new int[]{1,2,3,4,5}
// can omit the new of also declaring a variable
int[] w = {9,10,11,12,13}


/** 2D ARRAY */
//create an array of arraies
int[][] x;
//create an array of 4 arraies, each one has default value (null)
test = new int[4][];
//assign value to each array
test[0] = new int[]{1};
test[1] = new int[]{1,2};
test[3] = new int[]{1,2,3};
//declare 2D array and assign value
int[][] matrix = new int[][]{{1},{1,2},{1,2,3}};

/** 
 *  2D Array
 */

public class ArrayDanger {

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] z = new int[3][];
        z[0] = x[0];
        z[1] = x[1];
        z[2] = x[2];
        z[0][0] = -z[0][0];

        int[][] w = new int[3][3];
        System.arraycopy(x[0], 0, w[0], 0, 3);
        System.arraycopy(x[1], 0, w[1], 0, 3);
        System.arraycopy(x[2], 0, w[2], 0, 3);
        w[0][0] = -w[0][0];
        System.out.println("x[0][0]: " + x[0][0] + ", w[0][0]: " + w[0][0]);
    }    
} 
