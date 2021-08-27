package FrontEnd;

import UserInputs.ScannerInput;

public class UserMenu {

    public int mainmenu() {
        int menu = 0;
        while(menu < 1 || menu > 3){
            System.out.println("*** Main Menu ***");
            System.out.println("1. New User");
            System.out.println("2. Returning User");
            System.out.println("3. Exit");
            System.out.println("\nAction: ");
            menu = new ScannerInput().supplyInt.get();
        }
        return menu;
    }
}
