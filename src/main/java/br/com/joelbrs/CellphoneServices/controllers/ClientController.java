package br.com.joelbrs.CellphoneServices.controllers;

import br.com.joelbrs.CellphoneServices.dtos.ClientDTOIn;
import br.com.joelbrs.CellphoneServices.dtos.ClientDTOOut;
import br.com.joelbrs.CellphoneServices.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTOOut>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(clientService.findAllPaged(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTOOut> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTOOut> insert(@RequestBody ClientDTOIn dto) {
        return ResponseEntity.ok().body(clientService.insert(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTOOut> update(@PathVariable Long id, @RequestBody ClientDTOIn dto) {
        return ResponseEntity.ok().body(clientService.update(id,dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
