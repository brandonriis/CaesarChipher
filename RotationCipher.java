import java.util.Scanner;

interface RotationCipher {

    public String rotate (String text, int shift);

    public String decipher (String text);

    public double[] frequencies (String text);

    public double chiSquared (double freq, double english);




}
