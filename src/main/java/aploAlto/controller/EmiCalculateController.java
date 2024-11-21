package aploAlto.controller;

import aploAlto.Model.EmiCalculate;
import aploAlto.exception.CustomException;
import aploAlto.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class EmiCalculateController {
    @Autowired
    private EmiService emiService;

    @PostMapping("/emiCalculate")
    public ResponseEntity<EmiCalculate> saveEmi(@RequestBody EmiCalculate emiCalculate) {
        try{
            if (emiCalculate.getLoanAmount()==null){
                throw new CustomException("loan amount can not be null");
            }
            return new ResponseEntity<>(emiCalculate,HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Something went wrong: " + e.getMessage());
        }

    }


}
