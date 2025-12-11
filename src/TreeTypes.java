import java.util.Arrays;
import java.util.Random;

public class TreeTypes {

/// simplify worst case, get consistent results

    public static Node makeBalancedTree(int[] numbers){
        if (numbers.length == 0) return null;
        if (numbers.length == 1) return new Node (numbers[0], null, null) ;
        int midpoint = numbers.length / 2;
        int [] leftChild = Arrays.copyOfRange(numbers, 0, midpoint-1);
        int [] rightChild = Arrays.copyOfRange(numbers, midpoint, numbers.length);

        //System.out.println("Midpoint: "+midpoint+"\nLeft Child: "+leftChild.length+"\nRight Child Size: "+rightChild.length+"\n------------------------------");
        //System.out.println("Midpoint: "+midpoint+"\nLeft Child: "+leftChild[0]+" to "+leftChild[leftChild.length-1]+"\nRight Child: "+rightChild[0]+" to "+rightChild[rightChild.length-1]+"\n------------------------------");


        Node parent  = new Node (numbers[midpoint], makeBalancedTree(leftChild), makeBalancedTree(rightChild));
        return parent;
    }

    public static BSTI balancedTree(int[] numbers){
        //System.out.println("balanced made");
        return new BSTI (makeBalancedTree(numbers));
    }

    public static BSTI shuffledTree(int[] numbers){
        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);
        int[] shuffledNumbers = shuffle(copyOfNumbers);
        BSTI shuffled = new BSTI(new Node (shuffledNumbers[0], null, null));
        for (int i = 1; i < shuffledNumbers.length; i++){
            shuffled.insert(shuffledNumbers[i]);
        }
        return shuffled;
    }


    //make this much simpler
    public static BSTI linkedListTree(int[] numbers){
         BSTI linkedList = new BSTI(new Node (numbers[0], null, null));
        System.out.println("inserting into LinkedList");
         for (int i = 1; i < numbers.length; i++){

         }
         return linkedList;
    }




    //Fisher-Yates shuffle algorithm
    //https://www.geeksforgeeks.org/dsa/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
    public static int[] shuffle(int[] numbers){
        Random rgen = new Random();
        for (int i = numbers.length - 1; i > 0; i--){
            int j = rgen.nextInt(i+1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }




}
