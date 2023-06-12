package com.example.demo.inventory;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, String> {

	

}
