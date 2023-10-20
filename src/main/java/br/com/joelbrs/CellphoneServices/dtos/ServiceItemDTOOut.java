package br.com.joelbrs.CellphoneServices.dtos;

import br.com.joelbrs.CellphoneServices.enums.ServiceItemStatus;
import br.com.joelbrs.CellphoneServices.model.Client;
import br.com.joelbrs.CellphoneServices.model.Gadget;
import br.com.joelbrs.CellphoneServices.model.ServiceItem;
import br.com.joelbrs.CellphoneServices.model.pk.ServiceItemPK;

import java.time.LocalDate;

public class ServiceItemDTOOut {
    private ServiceItemPK id = new ServiceItemPK();
    private LocalDate inclusionDate;
    private LocalDate deliveredDate;
    private Long status;

    public ServiceItemDTOOut() {}

    public ServiceItemDTOOut(Client client, Gadget gadget, LocalDate inclusionDate, LocalDate deliveredDate, ServiceItemStatus status) {
        this.id.setClient(client);
        this.id.setGadget(gadget);
        this.inclusionDate = inclusionDate;
        this.deliveredDate = deliveredDate;
        setStatus(status);
    }

    public ServiceItemDTOOut(ServiceItem serviceItem) {
        this.id.setClient(serviceItem.getClient());
        this.id.setGadget(serviceItem.getGadget());
        this.inclusionDate = serviceItem.getInclusionDate();
        this.deliveredDate = serviceItem.getDeliveredDate();
        setStatus(serviceItem.getStatus());
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

    public Gadget getGadget() {
        return id.getGadget();
    }
}
