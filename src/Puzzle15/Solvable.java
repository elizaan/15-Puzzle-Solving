package Puzzle15;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solvable {
    int getInversionCount(List<Integer> list)
    {

        int count = 0;
        for (int i = 0; i < 15; i++)
        {
            for (int j = i + 1; j < 16; j++)
            {
                // count pairs(i, j) such that i appears
                // before j, but i > j.
                if (list.get(j)!=0 && list.get(i)!=0 && list.get(i)>list.get(j))
                    count++;
            }
        }
        return count;


    }


    int blankFind(int p[][])
    {
        for(int i = 3; i>=0; i--)
        {
            for (int j =3; j>=0; j--)
            {
                if(p[i][j]=='X')
                {
                    return 4 - i;
                }
            }
        }
       return Integer.MAX_VALUE;
    }

    public int isSolvable(int init[][], int goal[][])
    {
        List<Integer> initlist = new ArrayList<Integer>();
        List<Integer> goallist = new ArrayList<Integer>();
        for (int i = 0; i < init.length; i++) {
            // tiny change 1: proper dimensions
            for (int j = 0; j < init[i].length; j++) {
                // tiny change 2: actually store the values
                initlist.add(init[i][j]);
            }
        }

        for (int i = 0; i < init.length; i++) {
            // tiny change 1: proper dimensions
            for (int j = 0; j < init[i].length; j++) {
                // tiny change 2: actually store the values
                goallist.add(goal[i][j]);
            }
        }
        int inv1 = getInversionCount(initlist);
        int inv2 = getInversionCount(goallist);
        int sum1 = inv1 + blankFind(init);
        int sum2 = inv2 + blankFind(goal);
        if((sum1%2 == 0 && sum1%2==0) || (sum1%2 != 0 && sum1%2 != 0))

        {
             return 1;
        }

        else
            return 0;

    }


}



