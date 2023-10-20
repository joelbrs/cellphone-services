package br.com.joelbrs.CellphoneServices.model.pk;

import br.com.joelbrs.CellphoneServices.model.Client;
import br.com.joelbrs.CellphoneServices.model.Gadget;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ServiceItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "gadget_id")
    private Gadget gadget;

    private Integer sequenceNumber = 0;

    public ServiceItemPK() {}

    public ServiceItemPK(Client client, Gadget gadget, Integer nextSequenceNumber) {
        this.client = client;
        this.gadget = gadget;
        this.sequenceNumber = nextSequenceNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }
}
