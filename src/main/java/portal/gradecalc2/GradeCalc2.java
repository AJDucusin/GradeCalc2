package portal.gradecalc2;

import com.opencsv.exceptions.CsvValidationException;


public class GradeCalc2 {

    public static void main(String[] args) throws CsvValidationException {
        
        DBops dbOps = new DBops();
        dbOps.deleteRecordById("2");
        
    }
}
