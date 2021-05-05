package Puzzle15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PuzzleSolve {

    int costCalculate(int[][]initial, int[][]goal)  //h(x) for misplaced
    {
        int cnt = 0;
        int c = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (initial[i][j]!=c)
                {
                    cnt++;
                }
                c++;
            }
        }

        return cnt-1;
    }

    int Manhattan(int[][]initial)
    {
          int row_no;
          int col_no;
          int manDist=0;


          for(int i = 0 ;i<4; i++ )
          {
              for(int j=0;j<4;j++)
              {
                  if(initial[i][j]!=0)
                  {
                      row_no = (initial[i][j]-1)/4;
                      col_no = (initial[i][j]+3) % 4;
                      manDist= manDist+Math.abs(i-row_no)+Math.abs(j-col_no);
                  }
              }
          }
          return manDist;
    }


    void printPath(Node node)
    {
        if (node == null)
            return;
        printPath(node.parent);

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.print(node.initial[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();

    }
    void AStarSearch(int[][] initial,int[][]goal,int x, int y,int choice)
    {
        int count = 0;
        int row[] = {0,1,0,-1};
        int col[] = {1,0,-1,0};



        if(choice == 1)
        {
            Comparator<Node> costSorter = Comparator.comparing(Node::getCost);
            PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(costSorter);

            Node root = new Node(initial,null,0,x,y);
            root.cost = costCalculate(initial,goal);


            priorityQueue.add(root);
            System.out.println("hello:" + root.getCost());

            //int counter = 0;
            int expand=0;
            while (!priorityQueue.isEmpty())
            {
//            System.out.println("hi");
                Node min;

                min = priorityQueue.peek();
                priorityQueue.poll();
                expand++;

//            if(++counter < 20) {
//                System.out.println(min);
//                System.out.println("Cost = " + min.getCost() + ": " + min.level + " " + (min.getCost() - min.level));
//            }

//            System.out.println(count++);
//            System.out.println(min.getCost());
                if(min.getCost() == min.level)
                {
                    //printPath(min);
                    System.out.println("Number of expanded nodes : " + expand );
                    System.out.println("cost :" +min.level);
                    return;
                }

                for(int i =0;i<4;i++)
                {
                    if((i+2) % 4 == min.lastmove) continue;
                    if(((min.x + row[i]) >= 0 && (min.x + row[i]) < 4) && ((min.y+col[i]) >= 0 && (min.y+col[i]) < 4))
                    {
                        int[][] arr = new int[4][4];
                        for(int j=0; j<4; ++j) {
                            for(int k=0; k<4; ++k) {
                                arr[j][k] = min.initial[j][k];
                            }
                        }
                        int temp = arr[(min.x + row[i])][(min.y+col[i])];
                        arr[(min.x + row[i])][(min.y+col[i])] = arr[min.x][min.y];
                        arr[min.x][min.y] = temp;
                        Node child = new Node(arr,min,min.level+1,min.x + row[i],min.y+col[i]);
//                    if(counter < 20) System.out.println("Created child:\n" + child);

                        child.cost = costCalculate(child.initial,goal) + child.level;
                        child.lastmove = i;
                        priorityQueue.add(child);
                    }
                }




            }


        }
        else if(choice == 2)
        {
            Comparator<Node> costSorter = Comparator.comparing(Node::getCost);
            PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(costSorter);

            Node root = new Node(initial,null,0,x,y);
            root.cost = Manhattan(initial);

            priorityQueue.add(root);
            System.out.println("hello:" + root.getCost());

            int expand = 0;
            int counter = 0;
            while (!priorityQueue.isEmpty())
            {
//            System.out.println("hi");
                Node min =  new Node();

                min = priorityQueue.peek();
                priorityQueue.poll();
                expand++;

//            if(++counter < 20) {
//                System.out.println(min);
//                System.out.println("Cost = " + min.getCost() + ": " + min.level + " " + (min.getCost() - min.level));
//            }

//            System.out.println(count++);
//            System.out.println(min.getCost());
                if(min.getCost() == min.level)
                {
                    //printPath(min);
                    System.out.println("Number of explored node : " + expand);
                    System.out.println("cost :" +min.level);
                    return;
                }

                for(int i =0;i<4;i++)
                {
                    if((i+2) % 4 == min.lastmove) continue;
                    if(((min.x + row[i]) >= 0 && (min.x + row[i]) < 4) && ((min.y+col[i]) >= 0 && (min.y+col[i]) < 4))
                    {
                        int[][] arr = new int[4][4];
                        for(int j=0; j<4; ++j) {
                            for(int k=0; k<4; ++k) {
                                arr[j][k] = min.initial[j][k];
                            }
                        }
                        int temp = arr[(min.x + row[i])][(min.y+col[i])];
                        arr[(min.x + row[i])][(min.y+col[i])] = arr[min.x][min.y];
                        arr[min.x][min.y] = temp;
                        Node child = new Node(arr,min,min.level+1,min.x + row[i],min.y+col[i]);
//                    if(counter < 20) System.out.println("Created child:\n" + child);

                        child.cost = Manhattan(child.initial) + child.level;
                        child.lastmove = i;
                        priorityQueue.add(child);
                    }
                }




            }

        }

    }
}
