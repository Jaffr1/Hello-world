package com.example.csvpdf.service;

import com.example.csvpdf.model.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvToPdfService {

    // 1️⃣ Parse CSV
    public List<User> parseCsv(MultipartFile file) throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            User user = new User(data[0], data[1], Integer.parseInt(data[2]));
            users.add(user);
        }
        return users;
    }

    // 2️⃣ Generate PDF with table
    public File generatePdf(List<User> users) throws Exception {
        Document document = new Document();
        File pdfFile = new File("users.pdf");
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        document.add(new Paragraph("User Data", font));
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Table Header
        String[] headers = {"Name", "Email", "Age"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }

        // Table Rows
        for (User user : users) {
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(String.valueOf(user.getAge()));
        }

        document.add(table);
        document.close();
        return pdfFile;
    }
}