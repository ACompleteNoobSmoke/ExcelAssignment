package Inputs;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ScannerInput {

    private static Scanner scan = new Scanner(System.in);

    //String is too long.
    private Predicate<String> charTooLong = x -> x.length() > 1;

    //Character is not an alphabet
    private  Predicate<String> notAlphabet = x -> x.charAt(0) < 'A' || x.charAt(0) > 'Z';

    //Supplies the ability to get String;
    public Supplier<String> supplyString = () ->  scan.nextLine();

    //Supplies the ability to get Character.
    public Supplier<Character> supplyChar = () -> setChar();

    //Supplies the ability to get Int
    public Supplier<Integer> supplyInt = () -> setInt();



    //Modify int input
    private int setInt(){
        int newInt = 0;
        try{
            newInt = scan.nextInt();
            scan.nextLine();
        }catch(InputMismatchException e){
            scan.nextLine();
        }
        return newInt;
    }

    //Modify character input
    private char setChar(){
        String newChar = " ";
        newChar = supplyString.get();
        newChar = newChar.toUpperCase().trim();
        if(charTooLong.or(notAlphabet).test(newChar)) return '0';
        return newChar.charAt(0);
    }

    //Close Scanner
    public void closeScanner(){
        scan.close();
    }

}
