import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hellow World !");
        /** initilize array as counter and array list as alphabet holder */
        int[]  counters = new int[52];
        ArrayList<Character> alphabet = new ArrayList<>();
        fillAlphabet(alphabet);

        // read text file from working directory
        File file = new File("LincolinSpeech.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){              //read token by token
                String s = scanner.next();
                for (int i=0; i<s.length();i++){    //loop on token
                    if (alphabet.contains(s.charAt(i) )){ //find match
                        int index =  alphabet.indexOf(s.charAt(i));
                        counters[index]++;              // fill counter
                    }
                }
            }
        }// end scanning

        //now printing the result:
        for (int i =0; i<counters.length;i++){
             System.out.println("Occurrences of "+alphabet.get(i)+", is : "+counters[i]);
        }

    }//end main

    private static void fillAlphabet(ArrayList<Character> alphabet) {
        for (int i=0; i<26;i++){
            alphabet.add((char) (65+i));
        }
        for (int i=0;i<26;i++){
            alphabet.add((char)(97+i));
        }
    }
}
