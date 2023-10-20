package br.com.joelbrs.CellphoneServices.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_gadget")
public class Gadget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private BigDecimal piecePrice;
    private BigDecimal servicePrice;

    public Gadget() {}

    public Gadget(Long id, String model, BigDecimal piecePrice, BigDecimal servicePrice) {
        this.id = id;
        this.model = model;
        this.piecePrice = piecePrice;
        this.servicePrice = servicePrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return Objects.equals(id, gadget.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
