package aploAlto.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmiCalculate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Loan amount is required")
    @Column(nullable = false)
    private Long loanAmount;

    @NotNull(message = "Rate of interest is required")
    @Column(nullable = false)
    private int rateInterest;

    @NotNull(message = "Loan tenure is required")
    @Column(nullable = false)
    private int loanTenure;

    @Column(nullable = false)
    private double emi; // Add this field to store the calculated EMI

}
