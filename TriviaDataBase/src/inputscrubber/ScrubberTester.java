package inputscrubber;

import java.util.Arrays;
import java.util.Scanner;

public class ScrubberTester {
public static void main(String[] args){
        System.out.println("Scrubbbb it hard.");
        Scanner sc = new Scanner(System.in);
        String in1 = "A"; //to test chars
        String in2 = "TRUE"; //to test boolean null
        String in3 = "false"; //to test boolean full word
        String in4 = "t"; //to test boolean char
        String in5 = "F"; //to test match w/o case

        String in9 = ""; //to test null in shortScrubber
        String in10 = "1492"; //to test normal string composed of integers
        String in11 = ""; //to test null for intScrubber
        String in12 = "Dog";  //to test a String for intScrubber

        char out1 = Scrubber.charScrubber(in1, sc);
        System.out.println("Printing in/out charscrubber, input: " + in1 + ", output: " + out1);//for all of these print statements, in1 will be unchanged even if the input was not correctly formatted and the user was asked again for input
        boolean out2 = Scrubber.boolScrubber(in2, sc);
        System.out.println("Printing in/out charscrubber, input: " + in2 + ", output: " + out2);
        boolean out3 = Scrubber.boolScrubber(in3, sc);
        System.out.println("Printing in/out charscrubber, input: " + in3 + ", output: " + out3);
        boolean out4 = Scrubber.boolScrubber(in4, sc);
        System.out.println("Printing in/out charscrubber, input: " + in4 + ", output: " + out4);
        boolean out5 = Scrubber.boolScrubber(in5, sc);
        System.out.println("Printing in/out charscrubber, input: " + in5 + ", output: " + out5);


        String in6 = "George Washington"; //to test short answer string
        String in7 = "Georgy Zhukov";//to test for three string answer (NOT ALLOWED!!)
        String in8 = "Columbus"; //to test for one string answer

        String[] out6 = Scrubber.shortScrubber(in6, sc);
        System.out.println("Printing in/out shortScrubber, input: " + in6 + ", output: " + Arrays.toString(out6));
        String[] out7 = Scrubber.shortScrubber(in7, sc);
        System.out.println("Printing in/out shortScrubber, input: " + in7 + ", output: " + Arrays.toString(out7));
        String[] out8 = Scrubber.shortScrubber(in8, sc);
        System.out.println("Printing in/out shortScrubber, input: " + in8 + ", output: " + Arrays.toString(out8));




        String[] out9 = Scrubber.shortScrubber(in9, sc);
        System.out.println("Printing in/out shortScrubber, input: " + in9 + ", output: " + Arrays.toString(out9));
        int out10 = Scrubber.intScrubber(in10, sc);
        System.out.println("Printing in/out intScrubber, input: " + in10 + ", output: " + out10);
        int out11 = Scrubber.intScrubber(in11, sc);
        System.out.println("Printing in/out intScrubber, input: " + in11 + ", output: " + out11);
        int out12 = Scrubber.intScrubber(in12, sc);
        System.out.println("Printing in/out intScrubber, input: " + in12 + ", output: " + out12);
        sc.close();
    }

}
