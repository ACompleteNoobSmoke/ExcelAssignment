package Methods;

import ExcelObjects.ExcelFile;
import FrontEnd.UserMenu;
import Inputs.ScannerInput;
import LinkedLists.Sheet;
import Model.User;
import ObjectManager.ExcelManager;
import ObjectManager.UserManager;

public class AppMethods {

    private UserManager uManager;

    public AppMethods(){
        uManager = new UserManager();
    }

    private void createSpace(){System.out.println();}

    //Main Method Menu
    public User mainMenuMethod(UserMenu menu){
        int mainMenuInput = menu.mainMenu();
        if(mainMenuInput == 3){ new ScannerInput().closeScanner(); System.exit(0);}
        createSpace();
        return new UserMethods().getUserByOption(mainMenuInput, uManager);
    }

    //Option Menu For Either Excel, Sheet or Cell
    public void optionMenu(User currentUser, UserMenu menu){
        String userName = currentUser.getUserName();
        int optionInput = 0;
        while(optionInput != 4){
          optionInput  = menu.optionMenu(userName);
          createSpace();
          if(optionInput == 4) break;
          Object useThis = getObject(optionInput, currentUser);
          if(useThis != null) optionAction(useThis, userName);
        }
    }

    //Performs actions based on the object that is passed
    private void optionAction(Object currentObject, String name){
        if(currentObject instanceof ExcelManager){
            excelMenuMethod(name, (ExcelManager)currentObject);
        }else if(currentObject instanceof ExcelFile){
            sheetMenuMethod((ExcelFile)currentObject);
        }else if(currentObject instanceof Sheet){
            cellMenuMethod((Sheet)currentObject);
        }
    }

    //Returns Excel, Sheet or Cell object based on the option picked by the user
    private Object getObject(int optionInput, User currentUser){
        ExcelManager eManage = currentUser.getExcelManager();
        Object returnThis = eManage;
        if(optionInput != 1){
            String fileName = new ExcelMethods().setName();
            returnThis = eManage.getObjectByName(fileName);
            if(optionInput == 3 && returnThis != null){
                String sheetName = new SheetMethods().setName();
                returnThis = eManage.getObjectByName(fileName).getObjectByName(sheetName);
             }
        }
        return returnThis;
    }

    //********************************* OBJECT METHODS *********************************************//

    //Performs excel methods based on the input choice
    private void excelMenuMethod(String userName, ExcelManager eManager){
        int excelMenuInput = 0;
        while(excelMenuInput != 6){
            excelMenuInput = new UserMenu().excelMenu(userName);
            new ExcelMethods().excelMethodVoidSwitch(excelMenuInput, eManager);
        }
    }

    //Performs sheet methods based on the input choice
    private void sheetMenuMethod(ExcelFile file){
        int sheetMenuInput = 0;
        String fileName = file.getFileName();
        while(sheetMenuInput != 6){
            sheetMenuInput = new UserMenu().sheetMenu(fileName);
            new SheetMethods().sheetMethodVoidSwitch(sheetMenuInput,file);
        }
    }

    //Performs cell methods based on the input choice
    private void cellMenuMethod(Sheet sheet){
        int cellMenuInput = 0;
        String sheetName = sheet.getSheetName();
        while(cellMenuInput != 6){
            cellMenuInput = new UserMenu().cellMenu(sheetName);
            new CellMethods().cellMethodVoidOptions(cellMenuInput, sheet);
        }
    }
}
