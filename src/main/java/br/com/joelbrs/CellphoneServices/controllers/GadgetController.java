package br.com.joelbrs.CellphoneServices.controllers;

import br.com.joelbrs.CellphoneServices.dtos.GadgetDTOIn;
import br.com.joelbrs.CellphoneServices.dtos.GadgetDTOOut;
import br.com.joelbrs.CellphoneServices.services.GadgetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gadgets")
public class GadgetController {

    private final GadgetService gadgetService;

    public GadgetController(GadgetService gadgetService) {
        this.gadgetService = gadgetService;
    }

    @GetMapping
    public ResponseEntity<Page<GadgetDTOOut>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(gadgetService.findAllPaged(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GadgetDTOOut> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(gadgetService.findById(id));
    }

    @PostMapping
    public ResponseEntity<GadgetDTOOut> insert(@RequestBody GadgetDTOIn dto) {
        return ResponseEntity.ok().body(gadgetService.insert(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GadgetDTOOut> update(@PathVariable Long id, @RequestBody GadgetDTOIn dto) {
        return ResponseEntity.ok().body(gadgetService.update(id,dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gadgetService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
