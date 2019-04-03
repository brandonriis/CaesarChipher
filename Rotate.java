import java.util.Scanner;

public class Rotate {

    public static void main (String[] args){


        //Validate the number of console inputs
        if(args.length > 2){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Rotate n 'cipher text'");
            System.exit(0);
        }
        else if(args.length < 1){

            System.out.println("Too few parameters");
            System.out.println("Usage: java Rotate n 'cipher text'");
            System.exit(0);
        }

        int shift = new Integer(args[0]);
        String text = args[1];

        //Call appropriate class
        Caesar run = new Caesar(text, shift);



    }
}
