package com.example.demo.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService itemService;
			
	@GetMapping("/")
	public String sayHello() {
		return "hello, Everything start from '/items', so go ahead.";
	}
	
	@GetMapping("/items")
	@ApiOperation( value = "List of the inventory", 
	notes = "Find all the items in the inventory", response = Item.class)
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@PostMapping("/items")
	@ApiOperation( value = "Add an items to stock", 
	notes = "Add an item to the stock from the request body", response = Item.class)
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}

	@GetMapping("/items/{no}")
	@ApiOperation( value = "Read item details by item no", 
	notes = "Find a specific item by the item's no", response = Item.class)
	public Item getItem(@PathVariable String no) {
		return itemService.getItem(no);
	}
	
	@PutMapping("/items/{no}/w/{quantity}")
	@ApiOperation( value = "Withdrawal quantity of a specific item from stock", 
	notes = "Make a withdrawal of the item assuming that quantity exists in the inventory and return it with the new quantity", response = Item.class)
	public Item withdrawalItem(@PathVariable String no, @PathVariable String quantity) {
		Item item = itemService.getItem(no);
		String currQuantity = item.getAmount() ;
		int newQ = Integer.parseInt(currQuantity) - Integer.parseInt(quantity);
		if(newQ < 1)
		{
			System.out.println("the new quantity is negative " +newQ
					+" and therefore you can NOT make this item withdrawal");
			return item;
		}
		item.setAmount( String.valueOf(newQ));
		return itemService.updateItem(no, item);
	}

	@PutMapping("/items/{no}/d/{quantity}")
	@ApiOperation( value = "Deposit quantity of a specific item to stock", 
	notes = "Make a deposit of an item and return it with the new quantity", response = Item.class)
	public Item depositItem(@PathVariable String no, @PathVariable String quantity) {
		Item item = itemService.getItem(no);
		String currQuantity = item.getAmount() ;
		int newQuantity = Integer.parseInt(currQuantity) + Integer.parseInt(quantity);
		item.setAmount( String.valueOf(newQuantity));
		return itemService.updateItem(no, item);
	}
	
	@DeleteMapping("/items/{no}")
	@ApiOperation( value = "Delete an item from stock", 
	notes = "Delete an item and return it", response = Item.class)
	public Item deleteItem(@PathVariable("no") String no) {
		return itemService.deleteItem(no);
	}
	
}
