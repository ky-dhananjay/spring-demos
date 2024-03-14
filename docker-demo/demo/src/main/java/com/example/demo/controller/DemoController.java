package com.example.demo.controller;

import com.example.demo.model.domain.InvoiceModel;
import com.example.demo.model.domain.Student;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/app")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final StudentRepository studentRepository;
    private final InvoiceService invoiceService;

    public DemoController(StudentRepository studentRepository, InvoiceService invoiceService) {
        this.studentRepository = studentRepository;
        this.invoiceService = invoiceService;
    }

    @GetMapping
    ResponseEntity<?> greet() {
        logger.info("from docker at : " + System.currentTimeMillis());
        return ResponseEntity.ok().body("Hello from docker container");
    }
    @PostMapping
    ResponseEntity<Student> addStudent(@RequestBody StudentRequest studentRequest){
        Student student = Student.builder()
            .email(studentRequest.getEmail())
            .firstName(studentRequest.getFirstName())
            .lastName(studentRequest.getLastName())
            .build();
        //Student student1 = studentRepository.save(student);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/students/all")
    ResponseEntity<List<Student>> getAllStudent(){
        //List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok().body(Arrays.asList());
    }
    @GetMapping("/students/list/pdf")
    ResponseEntity<List<Student>> getAllStudentListInPdf(){
        //List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok().body(Arrays.asList());
    }
    @GetMapping("/invoice")
    ResponseEntity<File> getInvoicePdf() throws IOException {
        InvoiceModel invoiceModel = InvoiceModel.builder()
            .id("123456")
            .productName("testing product")
            .orderId("0-123")
            .orderDate("2023-12-13")
            .price(12.35)
            .quantity(1)
            .totalProductPrice(12.35)
            .saleTax(4.5)
            .paymentProcessingFee(0.0)
            .tvelpFee(0.0)
            .travelerReward(3.0)
            .estimatedTotalInUsd(15.0)
            .estimatedTotalInInr(1200.0)
            .build();
        File pdfFile = invoiceService.generateInvoiceFor(invoiceModel);
        return ResponseEntity.ok().body(pdfFile);
    }
}
