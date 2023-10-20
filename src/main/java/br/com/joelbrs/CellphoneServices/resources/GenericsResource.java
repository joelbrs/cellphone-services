package br.com.joelbrs.CellphoneServices.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericsResource<T, K> {
    Page<T> findAllPaged(Pageable pageable);
    T findById(Long id);
    T insert(K dto);
    T update(Long id, K dto);
    T delete(Long id);
}
