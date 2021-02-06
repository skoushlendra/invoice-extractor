package com.example.pdftext.service;

import java.util.Objects;

public class Product {
    private String productCategoryCssClass;
    private String productCode;
    private String productName;
    private String marketPrice;
    private String discountedPrice;

    public String getProductCategoryCssClass() {
        return productCategoryCssClass;
    }

    public void setProductCategoryCssClass(String productCategoryCssClass) {
        this.productCategoryCssClass = productCategoryCssClass;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productCode.equals(product.productCode) && productName.equals(product.productName) && marketPrice.equals(product.marketPrice) && discountedPrice.equals(product.discountedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, marketPrice, discountedPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCategoryCssClass='" + productCategoryCssClass + '\'' +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", marketPrice='" + marketPrice + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                '}';
    }
}
