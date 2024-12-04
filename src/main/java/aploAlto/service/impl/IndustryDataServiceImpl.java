package aploAlto.service.impl;

import aploAlto.Model.IndustryData;
import aploAlto.repository.IndustryDataRepository;
import aploAlto.service.CSVService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class IndustryDataServiceImpl implements CSVService {

    private IndustryDataRepository repository;

    public void saveDataFromCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> rows = reader.readAll();

            // Skip header
            rows.stream().skip(1).forEach(row -> {
                IndustryData data = new IndustryData();
                data.setYear(row[0]);
                data.setIndustryAggregationNZSIOC(row[1]);
                data.setIndustryCodeNZSIOC(row[2]);
                data.setIndustryNameNZSIOC(row[3]);
                data.setUnits(row[4]);
                data.setVariableCode(row[5]);
                data.setVariableName(row[6]);
                data.setVariableCategory(row[7]);
                data.setValue(row[8].isEmpty() ? null : Double.valueOf(row[8]));
                data.setIndustryCodeANZSIC06(row[9]);
                repository.save(data);
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
