# ResturantProjects

The following brifely approaches would be taken to develop the project.

1> Read file input.txt. Put the values into a map.

2> Considered first row is the value with totaltimes in minutes t and Number of items N present in the menu. Converting t mins to sesc assign the value into totalTimeToEat . After getting the values from first row remove the row from the map.

3> Populate items for the menu like itemID: 1 DishName: DIsh 1, itemID: 2 DishName: DIsh 2 etc. 

4> Calculate total no. of items can be eaten within the time totalTimeToEat secs and populating the SatisfactoryLimit & TimeTaken for these items. 

For implemeting this logic I used Greedy algorithm. 

I used a loop upto total number of items on menu through iterating the map and assign the timeTakenPerDish and the satisfactoryLimit of each item from the map.
Now if totalTimeToEat < timeTakenPerDish, I continue the loop to find if there is any dish present for what totalTimeToEat > timeTakenPerDish.
Else if totalTimeToEat > timeTakenPerDish, I consider the dish has been taken and the value totalTimeToEat is decreased by timeTakenPerDish. and poulating the SatisfactoryLimit & TimeTaken for the item.
		Else poulating the SatisfactoryLimit & TimeTaken for the item and making totalTimeToEat = 0

5> After the completion of the loop sorted the items of the menu according to the SatisfactoryLimit in descending order 

6> After sorting return the first the item of the menu. The SatisfactoryLimit of this item will be the Maximum Satisfaction Value. 
