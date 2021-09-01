package Methods;

import ExcelObjects.ExcelFile;
import Inputs.SheetInputs;
import LinkedLists.Sheet;
import Model.User;
import ObjectManager.ExcelManager;

public class SheetMethods extends SheetInputs {

    public Sheet createNewSheet(ExcelFile excelfile){
        System.out.println("*** Create New Sheet ***");
        String sheetName = setName2(excelfile);
        excelfile.add(new Sheet(sheetName));
        return excelfile.getObjectByName(sheetName);
    }

    public Sheet searchSheetFile(ExcelFile excelFile){
        System.out.println("*** Search Sheet File ***");
        String sheetName = setName();
        return excelFile.search(sheetName);
    }

    public void updateSheetName(ExcelFile excelFile){
        System.out.println("*** Update Sheet Name ***");
        String sheetName = setName();
        String updatedSheetName = setUpdatedName();
        boolean updated = excelFile.update(sheetName, updatedSheetName);
        String message = updated ? sheetName + " Has Been Updated To " + updatedSheetName:
                sheetName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    public void removeSheetFile(ExcelFile excelFile){
        System.out.println("*** Remove Sheet File ***");
        String sheetName = setName();
        boolean deleted = excelFile.remove(sheetName);
        String message = deleted ? sheetName + " Has Been Deleted From Database" :
                sheetName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    public void viewAllFiles(ExcelFile excelFile){
        System.out.println("*** View All Files ***\n");
        if(excelFile.getSheetSize() == 0){
            System.out.println("Database Is Currently Empty\n");
            return;
        }
        excelFile.showAll();
    }

    public static void main(String[] args) {
        SheetMethods sheetMethods = new SheetMethods();
        User newUser = new User("Osaretin", "Omofonmwan", "OsoInfinite95", "Oso");
        ExcelManager uManage = newUser.getExcelManager();
        ExcelFile myFile = new ExcelFile("FileNumber1");
        uManage.add(myFile);
        myFile = uManage.getObjectByName("FileNumber1");
        sheetMethods.createNewSheet(myFile);
        sheetMethods.createNewSheet(myFile);
        newUser.getExcelManager().getObjectByName("FileNumber1").showAll();

    }
}
