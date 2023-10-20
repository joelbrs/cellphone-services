package br.com.joelbrs.CellphoneServices.repositories;

import br.com.joelbrs.CellphoneServices.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
