package br.com.joelbrs.CellphoneServices.dtos;

import br.com.joelbrs.CellphoneServices.model.Client;
import br.com.joelbrs.CellphoneServices.model.ServiceItem;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTOOut {

    private Long id;
    private String name;
    private String cpf;
    private Set<ServiceItemDTOOut> services = new HashSet<>();

    public ClientDTOOut() {}

    public ClientDTOOut(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        setServices(client.getServices());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<ServiceItemDTOOut> getServices() {
        return services;
    }

    public void setServices(Set<ServiceItem> services) {
        this.services = services.stream().map(ServiceItemDTOOut::new).collect(Collectors.toSet());
    }
}
