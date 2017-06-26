package com.tech.assign.restaurant;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
	
	private int totalTimeToEat = 0;
	private int menuItemsCount = 0;
	private Map<String,String> map ;

	//Constructor of the CustomerService
	public CustomerService(Map<String,String> map) {
		this.map = map;
	}
	/*
	 * Calculate total no. of items can be eaten within the maximum time t minutes 
	 * and populating the SatisfactoryLimit & TimeTaken 
	 * 
	 *  
	 */

	private Integer calculateTotalItemsToEat() {
		int itemCount = 0;
		Integer[] eatingTimes = new Integer[map.size()];
		Integer[] degreeOfSatisfactions = new Integer[map.size()];
		for (Map.Entry<String, String> entry : map.entrySet())
		{
			degreeOfSatisfactions[itemCount] = Integer.parseInt(entry.getKey());
			eatingTimes[itemCount] = Integer.parseInt(entry.getValue());
			itemCount++;
		}
		
		return getMaxEatingSatisfaction(totalTimeToEat,eatingTimes,degreeOfSatisfactions,menuItemsCount);
	}
	// Gordan's best satisfaction/performance on the act of eating
		private Integer getMaxEatingSatisfaction(Integer timeLimit, Integer eatingTimes[], Integer degreeOfSatisfactions[],
				Integer menuItemCount) {
			if (menuItemCount != eatingTimes.length || menuItemCount != degreeOfSatisfactions.length) {
				//throw new InvalidInputFormatException();
			}
			Integer i, w;
			Integer satisfactionMatrix[][] = new Integer[menuItemCount + 1][timeLimit + 1];
			for (i = 0; i <= menuItemCount; i++) {
				for (w = 0; w <= timeLimit; w++) {
					if (i == 0 || w == 0)
						satisfactionMatrix[i][w] = 0;
					else if (eatingTimes[i - 1] <= w)
						satisfactionMatrix[i][w] = Math.max(
								degreeOfSatisfactions[i - 1] + satisfactionMatrix[i - 1][w - eatingTimes[i - 1]],
								satisfactionMatrix[i - 1][w]);
					else
						satisfactionMatrix[i][w] = satisfactionMatrix[i - 1][w];
				}
			}
			String text = String.format(
					"\nInput: \n\tTime Limit: %s\n\tEating Times: %s\n\tDegree Of Satisfaction: %s\n\tMenu Item Count:%s\nOutput: \n\tMax Sat. Degree:%s\n",
					timeLimit, Arrays.toString(eatingTimes), Arrays.toString(degreeOfSatisfactions), menuItemCount,
					satisfactionMatrix[menuItemCount][timeLimit]);
			System.out.println(text);
			return satisfactionMatrix[menuItemCount][timeLimit];
		}
	/**
	 * This method return MaxSatisfactoryLevel 
	 */
	public Integer findMaxSatisfactionLabel() {

		readTimeAndItemCount(map);
		return calculateTotalItemsToEat();


	}
	/**
	 * Read the time and Item available in the first element of the Map.
	 * This method also remove the first element from the map after reading the values 
	 * and assigning it to totalTimeToEat and menuItemsCount variables.
	 * 
	 * @param map
	 */
	private void readTimeAndItemCount(Map<String,String> map) {
		Map.Entry<String,String> entry=map.entrySet().iterator().next();
		totalTimeToEat = Integer.parseInt(entry.getKey());
		menuItemsCount = Integer.parseInt(entry.getValue());
		
		map.remove(entry.getKey());
		return ;

	}

	

}
