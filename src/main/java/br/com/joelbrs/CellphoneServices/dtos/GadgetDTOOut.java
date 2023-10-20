package br.com.joelbrs.CellphoneServices.dtos;

import br.com.joelbrs.CellphoneServices.model.Gadget;

import java.math.BigDecimal;

public class GadgetDTOOut {

    private Long id;
    private String model;
    private BigDecimal piecePrice;
    private BigDecimal servicePrice;

    public GadgetDTOOut() {}

    public GadgetDTOOut(Gadget gadget) {
        this.id = gadget.getId();
        this.model = gadget.getModel();
        this.piecePrice = gadget.getPiecePrice();
        this.servicePrice = gadget.getServicePrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
