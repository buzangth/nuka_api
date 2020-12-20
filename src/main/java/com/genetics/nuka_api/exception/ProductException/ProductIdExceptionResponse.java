package com.genetics.nuka_api.exception.ProductException;

public class ProductIdExceptionResponse {

    private String productName;

    public ProductIdExceptionResponse(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
