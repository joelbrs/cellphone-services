package br.com.joelbrs.CellphoneServices.dtos;

import java.math.BigDecimal;

public class GadgetDTOIn {
    private String model;
    private BigDecimal piecePrice;
    private BigDecimal servicePrice;

    public GadgetDTOIn() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPiecePrice() {
        return piecePrice;
    }

    public void setPiecePrice(BigDecimal piecePrice) {
        this.piecePrice = piecePrice;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    public BigDecimal getProfit() {
        return servicePrice.subtract(piecePrice);
    }
}
