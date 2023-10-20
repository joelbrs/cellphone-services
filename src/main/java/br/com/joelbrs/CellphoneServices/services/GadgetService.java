package br.com.joelbrs.CellphoneServices.services;

import br.com.joelbrs.CellphoneServices.dtos.GadgetDTOIn;
import br.com.joelbrs.CellphoneServices.dtos.GadgetDTOOut;
import br.com.joelbrs.CellphoneServices.model.Gadget;
import br.com.joelbrs.CellphoneServices.repositories.GadgetRepository;
import br.com.joelbrs.CellphoneServices.resources.GenericsResource;
import br.com.joelbrs.CellphoneServices.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GadgetService implements GenericsResource<GadgetDTOOut, GadgetDTOIn> {

    private final GadgetRepository gadgetRepository;

    public GadgetService(GadgetRepository gadgetRepository) {
        this.gadgetRepository = gadgetRepository;
    }

    @Override
    public Page<GadgetDTOOut> findAllPaged(Pageable pageable) {
        return gadgetRepository.findAll(pageable).map(GadgetDTOOut::new);
    }

    @Override
    public GadgetDTOOut findById(Long id) {
        return new GadgetDTOOut(gadgetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public GadgetDTOOut insert(GadgetDTOIn dto) {
        Gadget gadget = new Gadget();

        dtoToEntity(dto, gadget);
        return new GadgetDTOOut(gadgetRepository.save(gadget));
    }

    @Override
    public GadgetDTOOut update(Long id, GadgetDTOIn dto) {
        try {
            Gadget gadget = gadgetRepository.getReferenceById(id);

            dtoToEntity(dto, gadget);
            return new GadgetDTOOut(gadgetRepository.save(gadget));
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public void delete(Long id) {
        gadgetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        try {
            gadgetRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity Violation");
        }
    }

    private void dtoToEntity(GadgetDTOIn dto, Gadget gadget) {
        gadget.setModel(dto.getModel());
        gadget.setPiecePrice(dto.getPiecePrice());
        gadget.setServicePrice(dto.getServicePrice());
    }
}
