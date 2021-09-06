package Methods;

import ExcelObjects.ExcelFile;
import Inputs.ExcelInputs;
import ObjectManager.ExcelManager;

public class ExcelMethods extends ExcelInputs {

    //Creates a new file and adds it to local databse
    private ExcelFile createNewFile(ExcelManager eManager){
        System.out.println("*** Create Excel File ***");
        String fileName = setName2(eManager);
        eManager.add(new ExcelFile(fileName));
        return eManager.getObjectByName(fileName);
    }

    //Searches the local database for an excel file
    private ExcelFile searchFile(ExcelManager eManager){
        System.out.println("*** Search Excel File ***");
        String fileName = setName();
        ExcelFile foundFile = eManager.search(fileName);
        if(foundFile == null)
            System.out.println(fileName + " Could Not Be Found\n");
        return foundFile;
    }

    //Update the excel file name in the local database
    private void updateFileName(ExcelManager eManager){
        System.out.println("*** Update File Name ***");
        String fileName = setName();
        String updatedFileName = setUpdatedName();
        boolean updated = eManager.update(fileName, updatedFileName);
        String message = updated ? fileName + " Has Been Updated To " + updatedFileName:
                fileName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    //Removes an excel file from the local database
    private void removeFile(ExcelManager eManager){
        System.out.println("*** Remove Excel File ***");
        String fileName = setName();
        boolean deleted = eManager.remove(fileName);
        String message = deleted ? fileName + " Has Been Deleted From Database" :
                fileName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }

    //Prints all of the existing excel file in the local database
    private void viewAllFiles(ExcelManager excelManager){
        System.out.println("*** View All Files ***\n");
        if(excelManager.getfileSize() == 0){
            System.out.println("Database Is Currently Empty\n");
            return;
        }
        excelManager.showAll();
    }

    //Performs excel method based on the user input choice
    public void excelMethodVoidSwitch(int excelMenuInput, ExcelManager eManager){
        switch (excelMenuInput){
            case 1: createNewFile(eManager); break;
            case 2: searchFile(eManager); break;
            case 3: updateFileName(eManager); break;
            case 4: removeFile(eManager); break;
            case 5: viewAllFiles(eManager); break;
        }
    }
}
