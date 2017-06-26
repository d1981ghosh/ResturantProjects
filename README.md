# ResturantProjects

The following brifely approaches would be taken to develop the project.

1> Read file input.txt. Put the values into a map.

2> Considered first row is the value with totaltimes t and Number of items N present in the menu. Converting t mins to sesc assign the value into totalTimeToEat . After getting the values from first row remove the row from the map.

3> Populate items for the menu like itemID: 1 DishName: DIsh 1, itemID: 2 DishName: DIsh 2 etc. 

4> Calculate total no. of items can be eaten within the time totalTimeToEat and populating the SatisfactoryLimit & TimeTaken for these items. For implemeting this logic I used KnapSack algorithm. 

6> After sthis return the Maximum Satisfaction Value. 
