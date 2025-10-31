package com.example.csvpdf.controller;

import com.example.csvpdf.model.User;
import com.example.csvpdf.service.CsvToPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class CsvPdfController {

    @Autowired
    private CsvToPdfService csvToPdfService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            List<User> users = csvToPdfService.parseCsv(file);
            File pdf = csvToPdfService.generatePdf(users);
            return ResponseEntity.ok("CSV uploaded and PDF generated: " + pdf.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadPdf() throws Exception {
        File file = new File("users.pdf");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=users.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(file.length())
                .body(resource);
    }
}