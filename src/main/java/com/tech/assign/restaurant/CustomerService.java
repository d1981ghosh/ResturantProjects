package com.tech.assign.restaurant;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

/**
 * Customer consumes items from the menu. Typically from the input file. For the
 * given T minutes, customer will start to consume dishes and this will happen
 * until the summation of the time he takes to consume N dishes is less than the
 * given T minutes.
 *
 */
@Service
public class CustomerService {
	public CustomerService() {}
	private String customerName;

	// Time in seconds
	private int sumTimeToEatAllItem = 0;
	private int menuItemsCount = 0;
	private int totalTimeToEat = 0;
	private Map<String,String> map ;
	private Boolean hasCrossedTime = Boolean.FALSE;

	private Menu menu;

	//Constructor of the CustomerService
	public CustomerService(String customerName, Map<String,String> map, Menu menu) {
		this.customerName = customerName;
		this.menu = menu;
		this.map = map;
	}
	/*
	 * Calculate # of items can be eaten within the maximum time t minutes
	 * 
	 *  @param totalTimeToEat
	 */
	private void calculateNoOfItemsToEat(int totalTimeToEat) {
		int itemCnt = 0;
		for (Map.Entry<String, String> entry : map.entrySet())
		{
			if (!hasCrossedTime) {
				sumOfTimeTakenForDish(entry,itemCnt);
				itemCnt++;
			}
			else
				break;
		}
		//printAllSatisfactoryLimit();
		return ;
	}
	/**
	 * This method return MaxSatisfactoryLevel 
	 */
	public Item findMaxSatisfactionLabel() {

		readTimeAndItemCount(map);
		menu.populateItems(menuItemsCount);
		calculateNoOfItemsToEat(totalTimeToEat);

		return findMaxSatisfactoryLevel(menu.getItems());

	}
	/**
	 * Read the time and Item available in the first element of the Map.
	 * This method also remove the first element from the map after reading the values 
	 * and assigning it to totalTimeToEat and menuItemsCount variables.
	 * 
	 * @param map
	 */
	private Map<String,String> readTimeAndItemCount(Map<String,String> map) {
		Map.Entry<String,String> entry=map.entrySet().iterator().next();
		totalTimeToEat = Integer.parseInt(entry.getKey());
		menuItemsCount = Integer.parseInt(entry.getValue());
		totalTimeToEat = totalTimeToEat * 60;
		
		map.remove(entry.getKey());
		return map;

	}

	/**
	 * Sort the Item array with the help of customized comparator class.
	 * 
	 * Identifies the max satisfactory Level that consumer has experienced with
	 * the particular dish item.
	 * 
	 * @param itemList
	 */
	private Item findMaxSatisfactoryLevel(List<Item> itemList) {
		Collections.sort(itemList, new SatisfactoryComparator());

		System.out.println(customerName + " had " + " max satisfaction " + itemList.get(0).getSatisfactoryLimit()
				+ " for the item '"+ itemList.get(0).getName()+"' in Menu " );
		return itemList.get(0);

	}

	/**
	 * This will sum the time taken for each dish
	 * and compares with the given input time. It will break out of the loop the
	 * moment the value reaches its the given input time.
	 * 
	 * @param entry
	 * @param itemCount
	 */
	private void sumOfTimeTakenForDish(Entry<String, String> entry, int itemCount) {

		
		int timeTakenPerDish = 0;
		String time= entry.getKey();
		String menuItemsCount=entry.getValue();
		timeTakenPerDish = Integer.parseInt(menuItemsCount);

		sumTimeToEatAllItem = sumTimeToEatAllItem + timeTakenPerDish;
		if (sumTimeToEatAllItem > totalTimeToEat) {
			hasCrossedTime = Boolean.TRUE;
			return;
		}
		menu.getItems().get(itemCount).setSatisfactoryLimit(Integer.parseInt(time));
		menu.getItems().get(itemCount).setTimeTaken(timeTakenPerDish);
	
		System.out.println(customerName + " had " + menu.getItems().get(itemCount).getName() + " for about "
				+ menu.getItems().get(itemCount).getTimeTaken() + " secs " + " and has got satisfactory level of "
				+ menu.getItems().get(itemCount).getSatisfactoryLimit());
		
	}

}
