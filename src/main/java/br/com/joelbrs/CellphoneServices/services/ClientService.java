package br.com.joelbrs.CellphoneServices.services;

import br.com.joelbrs.CellphoneServices.dtos.ClientDTOIn;
import br.com.joelbrs.CellphoneServices.dtos.ClientDTOOut;
import br.com.joelbrs.CellphoneServices.model.Client;
import br.com.joelbrs.CellphoneServices.repositories.ClientRepository;
import br.com.joelbrs.CellphoneServices.resources.GenericsResource;
import br.com.joelbrs.CellphoneServices.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements GenericsResource<ClientDTOOut, ClientDTOIn> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Page<ClientDTOOut> findAllPaged(Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClientDTOOut::new);
    }

    @Override
    public ClientDTOOut findById(Long id) {
        return new ClientDTOOut(clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public ClientDTOOut findByCpf(String cpf) {
        return new ClientDTOOut(clientRepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Client Not Found")));
    }

    @Override
    public ClientDTOOut insert(ClientDTOIn dto) {
        Client client = new Client();

        dtoToEntity(dto, client);
        return new ClientDTOOut(clientRepository.save(client));
    }

    @Override
    public ClientDTOOut update(Long id, ClientDTOIn dto) {
        try {
            Client client = clientRepository.getReferenceById(id);

            client.setName(dto.getName());
            return new ClientDTOOut(clientRepository.save(client));
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        try {
            clientRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity Violation");
        }
    }

    private void dtoToEntity(ClientDTOIn dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
    }
}
