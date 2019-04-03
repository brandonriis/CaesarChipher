import java.util.*;

class Caesar implements RotationCipher {

    public Caesar(String text, int shift) {

        System.out.println(rotate(text.toLowerCase(), shift));
    }

    public Caesar(String text) {

        System.out.println(decipher(text.toLowerCase()));
        //System.out.println(frequencies(text));
    }

    public String rotate(String text, int shift) {

        String cipher = "";

        //Loop through every character in the string.
        for (int i = 0; i < text.length(); i++){

            //Replace space for a space
            if (Character.isSpaceChar(text.charAt(i))){

                cipher += " ";
            }
            //Shift the character through the ASCII range by the shift supplied
            else{

                char ch = (char) (((int)text.charAt(i) + shift - 97) % 26 + 97);
                cipher += ch;
            }
        }

        return cipher;
    }

    public String decipher (String text){

        String decipher = "";
        double[] english = {0.0855, 0.0160, 0.0316, 0.0387,
                0.1210, 0.0218,20.0209, 0.0496, 0.0733, 0.0022,
                0.0081, 0.0421,30.0253, 0.0717, 0.0747, 0.0207,
                0.0010, 0.0633,40.0673, 0.0894, 0.0268, 0.0106,
                0.0183, 0.0019,50.0172, 0.0011};

        int shift = 0;
        double minScore = 1000;

        //Rotate text by every shift in the alphabet and store the frequency of each letter
        for(int i = 0; i < 26; i++){

            double tempScore = 0;

            double[] freq = frequencies(rotate(text, i));

            //Create chi score for each shifted text using letter frequency,
            //Adding up the total score to find the minimum value
            for(int q = 0; q < 26; q++){

                tempScore = tempScore + chiSquared(freq[q], english[q]);
            }

            //System.out.println(tempScore);

            //Replace the shift value if the new score is lower than the last
            if(tempScore < minScore){
                minScore = tempScore;
                shift = i;
            }

        }

        return rotate(text, shift);

    }

    public double[] frequencies (String text){


        char[] array = new char[] {'a','b','c','d','e',
                'f','g','h','i','j','k','l','m','n','o',
                'p','q','r','s','t','u','v','w','x','y','z'};
        double[] count = new double[26];

        //Store 0 in every space int he array
        for(int q = 0; q < count.length; q++){
            count[q] = 0;
        }

        double[] freq = new double[26];

        //For every character in the string
        for(int i = 0; i < text.length() ; i++){

            //System.out.println(text.toLowerCase().charAt(i));

            //Add 1 to the associated letter counter
            for(int c = 0; c < array.length; c++){

                if(text.charAt(i) == array[c]){
                    count[c] = count[c] + 1;
                }
            }

        }

        //Remove spaces from the string
        String textno = text.replace(" ", "");

        //If there is not instances of a character int he array set value to 0,
        //else calculate the frequency and add it to the array
        for(int b = 0; b < count.length; b++){

            if(count[b] == 0){
                freq[b] = 0;
                //System.out.println(freq[b]);
            }
            else{
                freq[b] = count[b] / textno.length() ;
                //System.out.println(freq[b]);
            }

        }

        return freq;
    }

    public double chiSquared (double freq, double english){

        double score = 0;

        //Return the Chi squared score
        score = Math.pow(freq - english, 2) / english;

        return score;


    }
}
