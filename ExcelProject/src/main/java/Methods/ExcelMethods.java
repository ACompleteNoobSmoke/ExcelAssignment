package Methods;

import ExcelObjects.ExcelFile;
import Inputs.ExcelInputs;
import Model.User;
import ObjectManager.ExcelManager;

public class ExcelMethods extends ExcelInputs {

    public ExcelFile createNewFile(ExcelManager eManager){
        System.out.println("*** Create Excel File ***");
        String fileName = setName2(eManager);
        ExcelFile newFile = new ExcelFile(fileName);
        eManager.add(newFile);
        return newFile;
    }

    public void removeFile(ExcelManager eManager){
        System.out.println("*** Remove Excel File ***");
        String fileName = setName();
        boolean deleted = eManager.remove(fileName);
        String message = deleted ? fileName + " Has Been Deleted From Database" :
                fileName + " Could Not Be Found In Database";
        System.out.println(message + "\n");
    }
}
