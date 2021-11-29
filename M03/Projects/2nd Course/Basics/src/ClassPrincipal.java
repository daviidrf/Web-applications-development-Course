/**
 *
 * @author David
 */
public class ClassPrincipal {
    
    public static void main (String []args){
        
        /*
         * 1  Complete the code with the necessary lines to compile the program
         */
        ClassOne unObjetClassOne = new ClassOne();

        unObjetClassOne.write("Hello world");
        unObjetClassOne.displayData();
        System.out.println("\n");
        unObjetClassOne.displaySecondElement();
        
    }
    
}

/*
 *  2 What is the difference between declaring ClassOne at line 13 or  at line 16?
 */

// SI SE DECLARA EN LA LINEA 13 ES UN ATRIBUTO DE LA CLASE PRINCIPAL Y
// SI ESTA EN LA 16 ES UN ATRIBUTO SOLO DEL METODO MAIN.


/*
 *  3 Declare a private attribute for ClassOne.  It must be an ArrayList of ClassTwo
 */


/*
 *  4 Initialize the ClassOne attribute adding three elements of ClassTwo
 */

/*
 *  5 Implement a method to show all the elements stored in the new attribute that you have initialized
 */

/*
 *  6 Implement a method to show the second element of the new attribute
 */