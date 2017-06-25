# ResturantProjects

The following brifely approaches would be taken to develop the project.

1> Read file input.txt. Put the values into a map with their current order in file.
2> Considered first row is the value with totaltimes in minutes and Number of items present in the menu.
3> Populate items for the menu like itemID: 1 DishName: DIsh 1, itemID: 2 DishName: DIsh 2 etc.
4> Calculate # of items can be eaten within the totaltimes using loop.
5> Add the SatisfactoryLimit and TimeTaken for each item.
6> Contunue Step 4 to 5 upto when the sum of TimeTaken < totaltimes in sec
7> Sort the menu according to the SatisfactoryLimit in descending order 
8> After sorting return the first result of the menu.
