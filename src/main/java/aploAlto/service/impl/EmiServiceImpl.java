package aploAlto.service.impl;

import aploAlto.Model.EmiCalculate;
import aploAlto.exception.CustomException;
import aploAlto.repository.EmiRepository;
import aploAlto.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmiServiceImpl implements EmiService {
    @Autowired
    private EmiRepository emiRepository;


    @Override
    public EmiCalculate save(EmiCalculate emiCalculate) {
        double loanAmount = emiCalculate.getLoanAmount(); //500000 rs
        double annualRateInterest = emiCalculate.getRateInterest(); // 11%
        int loanTenure = emiCalculate.getLoanTenure(); //5 year
        double monthlyRateInterest=0;
        double emi=0;

        try {
            // Convert annual rate of interest to a monthly rate in decimal
             monthlyRateInterest = annualRateInterest / (12 * 100);
        // Calculate EMI using the formula
         emi = (loanAmount * monthlyRateInterest * Math.pow(1 + monthlyRateInterest, loanTenure))
                / (Math.pow(1 + monthlyRateInterest, loanTenure) - 1);

        emiCalculate.setEmi(Math.round(emi)); // Assuming `emi` is a new field in `EmiCalculate`
        return this.emiRepository.save(emiCalculate);
        } catch (Exception e) {
            throw new CustomException("Something wrong with monthlyRateInterest ");
        }
    }

}
