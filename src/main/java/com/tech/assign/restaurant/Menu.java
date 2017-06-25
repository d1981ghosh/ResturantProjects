package com.tech.assign.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Menu has list of items/dishes that a restaurant can serve for the customer.
 *
 */
@Repository
public class Menu {

	List<Item> items;
	public Menu()
	{

	}
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/*
	 * Populate Menu items like Dish-1,Dish-2 etc. and assigning
	 * @param menuItemsCount
	 */
	public void populateItems(int menuItemsCount) {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < menuItemsCount; i++) {
			items.add(new Item((i+1), "Dish-" + (i+1)));
		}
		
		setItems(items);

	}

}
