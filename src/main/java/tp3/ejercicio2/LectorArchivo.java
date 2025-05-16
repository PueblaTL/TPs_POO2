package tp3.ejercicio2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    private String csvPath;

    public LectorArchivo(String csvPath) {
        this.csvPath = csvPath;
    }

    public List<String[]> toList(){
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = null;
            reader = new CSVReader(new FileReader(this.csvPath));
            String[] row = null;
            while ((row = reader.readNext()) != null) {csvData.add(row);}

            reader.close();
            csvData.remove(0);

            return csvData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
