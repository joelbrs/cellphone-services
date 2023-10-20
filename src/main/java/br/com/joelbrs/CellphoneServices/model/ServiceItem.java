package br.com.joelbrs.CellphoneServices.model;

import br.com.joelbrs.CellphoneServices.enums.ServiceItemStatus;
import br.com.joelbrs.CellphoneServices.model.pk.ServiceItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_service_item")
public class ServiceItem implements Serializable {

    @EmbeddedId
    private ServiceItemPK id = new ServiceItemPK();
    private LocalDate inclusionDate;
    private LocalDate deliveredDate;
    private Long status;

    public ServiceItem() {}

    public ServiceItem(ServiceItemPK id, LocalDate inclusionDate, LocalDate deliveredDate, ServiceItemStatus status) {
        this.id = id;
        this.inclusionDate = inclusionDate;
        this.deliveredDate = deliveredDate;
        setStatus(status);
    }

    public ServiceItem(ServiceItem serviceItem) {
        this.id = serviceItem.getId();
        this.inclusionDate = serviceItem.getInclusionDate();
        this.deliveredDate = serviceItem.getDeliveredDate();
        setStatus(serviceItem.getStatus());
    }

    public ServiceItemPK getId() {
        return id;
    }

    public void setId(ServiceItemPK id) {
        this.id = id;
    }

    public LocalDate getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(LocalDate inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public ServiceItemStatus getStatus() {
        return ServiceItemStatus.valueOf(status);
    }

    public void setStatus(ServiceItemStatus status) {
        this.status = status.getCode();
    }

    public Client getClient() {
        return id.getClient();
    }

    public Gadget getGadget() {
        return id.getGadget();
    }
}
