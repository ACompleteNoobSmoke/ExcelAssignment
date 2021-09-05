package Methods;

import ExcelObjects.ExcelFile;
import FrontEnd.UserMenu;
import LinkedLists.Sheet;
import Model.User;
import ObjectManager.ExcelManager;
import ObjectManager.UserManager;

public class AppMethods {

    private UserManager uManager;

    public AppMethods(){
        uManager = new UserManager();
    }

    public User mainMenuMethod(){
        int mainMenuInput = new UserMenu().mainMenu();
        if(mainMenuInput == 3) System.exit(0);
        return mainMenuInput == 1 ? new UserMethods().enterNewUser(uManager)
                : new UserMethods().returningUser(uManager);
    }

    public void optionMenu(User currentUser){
        String userName = currentUser.getUserName();
        int optionInput = 0;
        while(optionInput != 4){
          optionInput  = new UserMenu().optionMenu(userName);
          if(optionInput == 4) break;
          Object useThis = getObject(optionInput, currentUser);
          if(useThis != null) optionAction(useThis, userName);
        }
    }

    private void optionAction(Object currentObject, String name){
        if(currentObject instanceof ExcelManager){
            excelMenuMethod(name, (ExcelManager)currentObject);
        }else if(currentObject instanceof ExcelFile){
            sheetMenuMethod((ExcelFile)currentObject);
        }else if(currentObject instanceof Sheet){
            cellMenuMethod((Sheet)currentObject);
        }
    }

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

    private void excelMenuMethod(String userName, ExcelManager eManager){
        int excelMenuInput = 0;
        while(excelMenuInput != 6){
            excelMenuInput = new UserMenu().excelMenu(userName);
            new ExcelMethods().excelMethodVoidSwitch(excelMenuInput, eManager);
        }
    }

    private void sheetMenuMethod(ExcelFile file){
        int sheetMenuInput = 0;
        String fileName = file.getFileName();
        while(sheetMenuInput != 6){
            sheetMenuInput = new UserMenu().sheetMenu(fileName);
            new SheetMethods().sheetMethodVoidSwitch(sheetMenuInput,file);
        }
    }

    private void cellMenuMethod(Sheet sheet){
        int cellMenuInput = 0;
        String sheetName = sheet.getSheetName();
        while(cellMenuInput != 6){
            cellMenuInput = new UserMenu().cellMenu(sheetName);
            new CellMethods().cellMethodVoidOptions(cellMenuInput, sheet);
        }
    }
}
