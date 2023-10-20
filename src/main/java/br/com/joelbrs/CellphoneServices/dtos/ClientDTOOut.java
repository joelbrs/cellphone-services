package br.com.joelbrs.CellphoneServices.dtos;

import br.com.joelbrs.CellphoneServices.model.Client;

public class ClientDTOOut {

    private Long id;
    private String name;
    private String cpf;

    public ClientDTOOut() {}

    public ClientDTOOut(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
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
}
