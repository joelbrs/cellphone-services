package br.com.joelbrs.CellphoneServices.repositories;

import br.com.joelbrs.CellphoneServices.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Long> {
}
