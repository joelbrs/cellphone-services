package br.com.joelbrs.CellphoneServices.repositories;

import br.com.joelbrs.CellphoneServices.model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}
