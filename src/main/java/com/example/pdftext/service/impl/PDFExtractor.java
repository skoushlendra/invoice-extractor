package com.example.pdftext.service.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class PDFExtractor {

    public Set<String> extractOrderIdsFromPDF(MultipartFile... inputFiles) throws IOException {

        Set<String> orderNoSet = new HashSet<>();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        for (MultipartFile file : inputFiles) {
            if (file.getOriginalFilename().endsWith(".pdf")) {
                PDDocument pdfDocument = PDDocument.load(file.getInputStream());
                String text = pdfStripper.getText(pdfDocument);
                String[] lines = text.split("\\s+");
                for (int j = 0; j < lines.length; j++) {
                    String line = lines[j];
                    String[] temp1 = line.split(" ");
                    for (int k = 0; k < temp1.length; k++) {
                        String te = temp1[k];
                        char ch = te.charAt(0);
                        if (te.contains("_") && te.length() > 7 && te.length() < 12 && Character.isDigit(ch)) {
                            orderNoSet.add(te.split(",")[0]);
                        }
                    }
                }
                pdfDocument.close();
            }

        }
        return orderNoSet;
    }
}
