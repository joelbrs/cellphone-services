package br.com.joelbrs.CellphoneServices.dtos;

import br.com.joelbrs.CellphoneServices.enums.ServiceItemStatus;

import java.time.LocalDate;

public class ServiceItemDTOIn {
    private LocalDate inclusionDate;
    private LocalDate deliveredDate;
    private Long status;

    public ServiceItemDTOIn() {}

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
}
