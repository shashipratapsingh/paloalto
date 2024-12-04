package aploAlto.controller;

import aploAlto.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/csv")
public class CSVController {

    @Autowired
    private CSVService csvService;

    @PostMapping("/upload")
    public String uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty!";
        }
        try {
            // Save the file locally
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            // Process the file
            csvService.saveDataFromCSV(tempFile.getAbsolutePath());

            return "File uploaded and data saved!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
    }
}

