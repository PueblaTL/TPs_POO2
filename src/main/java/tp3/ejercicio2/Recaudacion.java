package tp3.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    public static final String PERMALINK = "permalink";
    public static final String NUMBER_EMPLOYEES = "number_employees";
    public static final String CATEGORY = "category";
    public static final String FUNDED_DATE = "funded_date";
    public static final String RAISED_AMOUNT = "raised_amount";
    public static final String RAISED_CURRENCY = "raised_currency";
    public static final int INDEX_COMPANY_NAME = 1;
    public static final int INDEX_CITY = 4;
    public static final int INDEX_STATE = 5;
    public static final int INDEX_ROUND = 9;
    private List<String[]> csvData;

    public Recaudacion(LectorArchivo lectorArchivo) {
        this.csvData = lectorArchivo.toList();
    }

    public List<Map<String, String>> where(Map<String, String> options) throws IOException {

        optionsFilter(options, COMPANY_NAME, INDEX_COMPANY_NAME);
        optionsFilter(options, CITY, INDEX_CITY);
        optionsFilter(options, STATE, INDEX_STATE);
        optionsFilter(options, ROUND, INDEX_ROUND);

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put(PERMALINK, csvData.get(i)[0]);
            mapped.put(COMPANY_NAME, csvData.get(i)[INDEX_COMPANY_NAME]);
            mapped.put(NUMBER_EMPLOYEES, csvData.get(i)[2]);
            mapped.put(CATEGORY, csvData.get(i)[3]);
            mapped.put(CITY, csvData.get(i)[INDEX_CITY]);
            mapped.put(STATE, csvData.get(i)[INDEX_STATE]);
            mapped.put(FUNDED_DATE, csvData.get(i)[6]);
            mapped.put(RAISED_AMOUNT, csvData.get(i)[7]);
            mapped.put(RAISED_CURRENCY, csvData.get(i)[8]);
            mapped.put(ROUND, csvData.get(i)[INDEX_ROUND]);
            output.add(mapped);
        }
        return output;
    }

    private void optionsFilter(Map<String, String> options, String company_name, int x) {
        if (options.containsKey(company_name)) {
            List<String[]> results = new ArrayList<String[]>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[x].equals(options.get(company_name))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }
    }
}
