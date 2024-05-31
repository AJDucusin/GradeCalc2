package portal.gradecalc2;

import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DBops {
    
    private String filePath = "C:\\Users\\ducus\\Desktop\\GradeCalc2\\testdb.csv";
    
    public void deleteRecordById(String idToDelete) throws CsvValidationException {
        List<String[]> allDataInRows = new ArrayList<>();
        boolean header = true;

        
        
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                if (header) {
                    header = false;
                    allDataInRows.add(row);
                    continue;
                }
                String id = row[0];
                if (!id.equals(idToDelete)) {
                    allDataInRows.add(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(allDataInRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
