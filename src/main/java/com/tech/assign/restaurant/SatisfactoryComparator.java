package com.tech.assign.restaurant;

import java.util.Comparator;

/**
 * Custom comparator to sort based on Satisfactory level in descending order.
 *
 */
public class SatisfactoryComparator implements Comparator<Item> {

	@Override
	public int compare(Item i1, Item i2) {
		// Sort in descending order.
		return i2.getSatisfactoryLimit() - i1.getSatisfactoryLimit();
	}

}