# root-bear

Suppose we have a canyon with perpendicular walls on either side of a forest. We assume a north wall and a south wall. Viewed from above we see the A&W RootBear attempting to get through the canyon.  
- assume trees are represented by points.
- assume the bear is a circle of given diameter d. 
- we are given a list of coordinates for the trees, y-coordinate of south wall and y-coordinate of north wall. 

This is a Java program that will process the input describing the RootBear problem, solve it using conversion to graph representation and output YES or NO.

## Input specification
First line contains 4 numbers 
(s n d t) 
where s is y-coordinate of the south wall, n is y-coordinate of the north wall, d is diameter of the RootBear, and t is the number of trees. The following t lines have two number each 
(x y) 
with x- and y-coordinate of a tree. 

## Output specification 
This program prints YES if the RootBear can get through, and NO otherwise. 
