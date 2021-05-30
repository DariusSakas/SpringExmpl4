package com.example.springexmpl4.service;

import com.example.springexmpl4.model.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
@AllArgsConstructor
public class PdfService {
    public static final String PDF_FILE_PATH = "C:\\pdfs\\myFirstPdf.pdf";
    private final EmployeeService employeeService;
    public void generatePdf() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(PDF_FILE_PATH));

        document.open();
        printOutPDFParagraph(document);

        printOutEmployeePDF(document);
        document.close();
    }

    private void printOutEmployeePDF(Document document) throws DocumentException {
        List<Employee> employees = employeeService.getAllEmployees();
        int counter = 1;
        Paragraph employeeParagraph;
        for (Employee employee : employees) {
            String text = counter++ + ". " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment().getName();
            employeeParagraph = new Paragraph(text);
            document.add(employeeParagraph);
        }
    }

    private void printOutPDFParagraph(Document document) throws DocumentException {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK); //optional
        Paragraph firstParagraph = new Paragraph("Hello PDF world!", font);
        document.add(firstParagraph);
    }
}
