

// Main method for the Pig Latin Converter
// This is the student starting file for Lab02bPigLatin
// You shouldn't need to change anything in this file.

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String piggie = PigLatin.convertWord(str);
        System.out.println();
        System.out.println("Converted word: " + piggie);

        System.out.println("goodbye!");
    }

}


