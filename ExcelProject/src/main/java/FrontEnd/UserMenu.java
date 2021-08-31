package FrontEnd;

import Inputs.ScannerInput;

public class UserMenu {

    public int mainMenu() {
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

    public int excelMenu(String userName){
        int menuChoice = 0;
        while(menuChoice < 1 || menuChoice > 6){
            System.out.println("*** Excel Menu ***");
            System.out.println("Hello " + userName +"\n");
            System.out.println("1. Create New File");
            System.out.println("2. Update File Name");
            System.out.println("3. Search File");
            System.out.println("4. Delete File");
            System.out.println("5. View All Files");
            System.out.println("6. Log Out");
            System.out.println("\nAction: ");
            menuChoice = new ScannerInput().supplyInt.get();
        }
        return menuChoice;
    }

    public int sheetMenu(String fileName){
        int sheetChoice = 0;
        while(sheetChoice < 1 || sheetChoice > 6){
            System.out.println("*** Sheet Menu ***");
            System.out.println("File Name: " + fileName + "\n");
            System.out.println("1. Create New Sheet");
            System.out.println("2. Update Sheet Name");
            System.out.println("3. Search Sheet");
            System.out.println("4. Delete Sheet");
            System.out.println("5. View All Sheets");
            System.out.println("6. Back");
            System.out.println("\nAction: ");
            sheetChoice = new ScannerInput().supplyInt.get();
        }
        return sheetChoice;
    }

    public int cellMenu(String sheetName){
        int cellChoice = 0;
        while(cellChoice < 1 || cellChoice > 6){
            System.out.println("*** Cell Menu ***");
            System.out.println("Sheet Name: " + sheetName + "\n");
            System.out.println("1. Insert Cell");
            System.out.println("2. Update Cell");
            System.out.println("3. Search Cell");
            System.out.println("4. Delete Cell");
            System.out.println("5. View All Cells");
            System.out.println("6. Back");
            System.out.println("\nAction: ");
            cellChoice = new ScannerInput().supplyInt.get();
        }
        return cellChoice;
    }
}
