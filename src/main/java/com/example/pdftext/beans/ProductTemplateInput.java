package com.example.pdftext.beans;

import com.example.pdftext.service.Product;

import java.util.List;

public class ProductTemplateInput {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
