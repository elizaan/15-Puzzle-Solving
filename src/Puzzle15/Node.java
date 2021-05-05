package Puzzle15;

import java.util.Arrays;

public class Node {

    Node parent;
    int x , y;
    int [][] initial;
    int cost;
    int level;
    int lastmove;

    @Override
    public String toString() {
        String ret = "";
        for(int i=0; i<4; ++i) {
            for(int j=0; j<4; ++j) {
                ret += (initial[i][j] + " ");
            }
            ret += "\n";
        }
        return ret;
    }

    Node()
    {
        parent = null;
        cost = -9999;
        level = 0;
        initial = new int[4][4];
        lastmove = -1;


        //initial = new int[4][4];
    }

    Node(int [][]p,Node parent,int level,int x, int y)
    {
        //Node node = new Node();
        //super();
        this.parent = parent;
        initial = new int[4][4];
        for (int i = 0; i<4; i++)
        {
            for(int j = 0; j<4 ;j++)
            {
                this.initial[i][j]= p[i][j];

            }


        }

        this.cost = 999999;
        this.level = level;
        this.x = x;
        this.y = y;

        this.lastmove = -1;

        //return node;

    }

    int getCost()
    {
        return this.cost;
    }




}




