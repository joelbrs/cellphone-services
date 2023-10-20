package br.com.joelbrs.CellphoneServices.services;

import br.com.joelbrs.CellphoneServices.dtos.ServiceItemDTOIn;
import br.com.joelbrs.CellphoneServices.dtos.ServiceItemDTOOut;
import br.com.joelbrs.CellphoneServices.model.Client;
import br.com.joelbrs.CellphoneServices.model.Gadget;
import br.com.joelbrs.CellphoneServices.model.pk.ServiceItemPK;
import br.com.joelbrs.CellphoneServices.repositories.ClientRepository;
import br.com.joelbrs.CellphoneServices.repositories.GadgetRepository;
import br.com.joelbrs.CellphoneServices.repositories.ServiceItemRepository;
import br.com.joelbrs.CellphoneServices.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceItemService {

    private final ServiceItemRepository repository;
    private final ClientRepository clientRepository;
    private final GadgetRepository gadgetRepository;

    public ServiceItemService(ServiceItemRepository repository, ClientRepository clientRepository, GadgetRepository gadgetRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.gadgetRepository = gadgetRepository;
    }

    @Transactional
    public ServiceItemDTOOut insert(Long idClient, Long idGadget, ServiceItemDTOIn dto) {
        Client client = clientRepository.findById(idClient).orElseThrow(() -> new ResourceNotFoundException("Client Not Found, ID: " + idClient));
        Gadget gadget = gadgetRepository.findById(idGadget).orElseThrow(() -> new ResourceNotFoundException("Gadget Not Found, ID: " + idGadget));

       /* var nextSequence = repository.findMaxSequenceNumber();

        ServiceItemPK pk = new ServiceItemPK(client, gadget);*/
        return null;
    }
}
