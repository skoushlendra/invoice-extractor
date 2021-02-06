package com.example.pdftext.controller;

import com.example.pdftext.beans.ProductTemplateInput;
import com.example.pdftext.util.ProductTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product/template")
public class ProductTemplateGenerator {

    @Autowired
    private ProductTemplate productTemplateService;

    @PostMapping ("/generate")
    public String getHtmlTemplateForProduct(@RequestBody ProductTemplateInput templateInput) {
        return productTemplateService.getHtmlTemplateForProducts(templateInput.getProducts());
    }
}
