# 15-Puzzle-Solving

Solving 15-puzzle by A* search 
Input: The input is a text file. The first line contains an integer n which indicates there are (n-1) problems to be solved. The second line describes the goal state.  The following (n-1) lines describe initial states, one initial state per line. Overall, the input file has (n+1) lines.  
For this assignment, we assume the goal state is going to be the standard goal state: the integers are in consecutive order with the blank space in the bottom  right corner. We also assume the blank state is described as a zero. So, the goal state is described by [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0] 
Output: The output should show the sequence of steps from the initial state to the goal state. Two heuristics (the misplaced tiles and the Manhattan distance)  should be used. The output should mention the path cost. Since both the heuristics are admissible, we would obtain the path with the same cost. To find  contrast, the output should print the number of expanded nodes (the size of the closed list) during the search.  
Solvability: For finding if the goal state is reachable, we need to determine the number of inversions of the initial state. You may read from the following two  links: 
(1) https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html 
(2) https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/ 
The rule for solvability (assuming the standard goal state) for 15-puzzle: 
the puzzle instance is solvable if 
(a) the blank is on an even row counting from the bottom (second-last, fourth-last, etc.) and the number of inversions is odd. or, 
(b) the blank is on an odd row counting from the bottom (last, third-last, fifth-last, etc.) and the number of inversions is even. An inversion occurs when a tile with a higher number precedes a tile with a lower number.
Counting inversions: 

Figure-1 
In the figure, X indicates the blank space. Here the sequence is 6 13 7 10 8 9 11 X 15 2 12 5 14 3 1 4.  
The number of inversions for tile-6 is 5 because tile-6 precedes tile2, tile-5, tile-3, tile-1, and tile-4. We may represent the blank space by zero, but it is not a tile  and it is not included when we count the number of inversions for tile-6. 
tile-6 
tile-13 
tile-7 
tile-10 
tile-8 
tile-9 
tile-11 
tile-15 
tile-2 
tile-12 
tile-5 
tile-14 
tile-3 
tile-1 
tile-4
5 
11 
5 
7 
5 
5 
5 
7 
1 
4 
3 
3 
1 
0 
0



The total number of inversions for this initial state (figure-1) is 5 + 11 + 5+ 7+ 5 + 5 + 5 + 7+ 1 + 4 + 3 + 3+ 1 + 0 + 0 = 62 
Similarly, we can determine the number of inversions for figure-2 and figure-3.

Figure-2 
tile-13 
tile-2 
tile-10 
tile-3 
tile-1 
tile-12 
tile-8 
tile-4 
tile-5 
tile-9 
tile-6 
tile-15 
tile-14 
tile-11 
tile-7
12 
1 
8 
1 
0 
7 
4 
0 
0 
2 
0 
3 
2 
1 
0



The total number of inversions for this initial state (figure-2) is 12 + 1 + 8 + 1 + 0 + 7 + 4 + 0 + 0 + 2 + 0 + 3 + 2 + 1 + 0 = 41 
Figure-3 
tile-3 
tile-9 
tile-1 
tile-15 
tile-14 
tile-11 
tile-4 
tile-6 
tile-13 
tile-10 
tile-12 
tile-2 
tile-7 
tile-8 
tile-5
2 
7 
0 
11 
10 
7 
1 
2 
6 
4 
4 
0 
1 
1 
0



The total number of inversions for this initial state (figure-3) is 2 + 7 + 0 + 11 + 10 + 7 + 1 + 2 + 6 + 4 + 4 + 0 + 1 + 1 + 0 = 56
