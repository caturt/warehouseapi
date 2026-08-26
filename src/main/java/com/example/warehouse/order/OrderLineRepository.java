package com.example.warehouse.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
    OrderLine findById(long id);

}
