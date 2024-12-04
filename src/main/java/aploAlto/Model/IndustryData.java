package aploAlto.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IndustryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;
    private String industryAggregationNZSIOC;
    private String industryCodeNZSIOC;
    private String industryNameNZSIOC;
    private String units;
    private String variableCode;
    private String variableName;
    private String variableCategory;
    private Double value;
    private String industryCodeANZSIC06;

    // Getters and setters
}
