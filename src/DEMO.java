


import java.util.Iterator;
import java.util.Random;



    public class DEMO {
    public static void main(String[] args) {


        Random rnd = new Random();
        DARRAY<Integer> myArray = new DARRAY<>(2);


        System.out.println(myArray.toString());
        myArray.add(19);
        myArray.add(12);
        myArray.add(23);
        myArray.add(21);
        myArray.delete(1);
        myArray.delete(77);

        System.out.println("the array after changes");
        System.out.println(myArray.toString());

        System.out.println("the array after sorting");
        Iterator<Integer> myIter = myArray.iterator();


        while (myIter.hasNext()) {
            int element = myIter.next();
            System.out.println(element);
        }

    }


}