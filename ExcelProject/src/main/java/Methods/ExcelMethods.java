package Methods;

import ExcelObjects.ExcelFile;
import Inputs.ExcelInputs;
import Model.User;

public class ExcelMethods extends ExcelInputs {

    public ExcelFile createNewFile(User user){
        System.out.println("*** Create Excel ***");
        String fileName = setName2(user.getExcelManager());
        ExcelFile newFile = new ExcelFile(fileName);
        user.getExcelManager().add(newFile);
        return newFile;
    }
}
