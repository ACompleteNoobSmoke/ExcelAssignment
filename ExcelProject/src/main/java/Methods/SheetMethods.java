package Methods;

import ExcelObjects.ExcelFile;
import Inputs.SheetInputs;
import LinkedLists.Sheet;
import ObjectManager.ExcelManager;

public class SheetMethods extends SheetInputs {

    private Sheet createNewSheet(ExcelFile excelfile){
        System.out.println("*** Create New Sheet ***");
        String sheetName = setName2(excelfile);
        excelfile.add(new Sheet(sheetName));
        return excelfile.getObjectByName(sheetName);
    }

    private Sheet searchSheetFile(ExcelFile excelFile){
        System.out.println("*** Search Sheet File ***");
        String sheetName = setName();
        return excelFile.search(sheetName);
    }

    private void updateSheetName(ExcelFile excelFile){
        System.out.println("*** Update Sheet Name ***");
        String sheetName = setName();
        String updatedSheetName = setUpdatedName();
        boolean updated = excelFile.update(sheetName, updatedSheetName);
        String message = updated ? sheetName + " Has Been Updated To " + updatedSheetName:
                sheetName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    private void removeSheetFile(ExcelFile excelFile){
        System.out.println("*** Remove Sheet File ***");
        String sheetName = setName();
        boolean deleted = excelFile.remove(sheetName);
        String message = deleted ? sheetName + " Has Been Deleted From Database" :
                sheetName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    private void viewAllSheets(ExcelFile excelFile){
        System.out.println("*** View All Files ***\n");
        if(excelFile.getSheetSize() == 0){
            System.out.println("Database Is Currently Empty\n");
            return;
        }
        excelFile.showAll();
    }

    public void sheetMethodVoidSwitch(int sheetMenuInput, ExcelFile excelFile){
        switch (sheetMenuInput){
            case 1: createNewSheet(excelFile); break;
            case 2: updateSheetName(excelFile); break;
            case 3: searchSheetFile(excelFile); break;
            case 4: removeSheetFile(excelFile); break;
            case 5: viewAllSheets(excelFile); break;
        }
    }
}
