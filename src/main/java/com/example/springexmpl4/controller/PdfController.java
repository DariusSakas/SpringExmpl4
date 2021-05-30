package com.example.springexmpl4.controller;

import com.example.springexmpl4.service.PdfService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/pdf")
@AllArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @GetMapping("/generate")
    public void generatePdf() throws DocumentException, FileNotFoundException {
        pdfService.generatePdf();
    }
}
