package Puzzle15;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class puzzleSolvable {


        public static void main(String[] args) {

            Solvable sa = new Solvable();
            int [][] initial = new int[4][4];
            int [][] goal = new int[4][4];
            Scanner scanner = new Scanner(System.in);

            for(int i = 0 ; i < 4 ; i++)
            {
                for(int j = 0 ; j < 4 ; j++)
                {
                    // String input = scanner.nextLine();
                    int num = scanner.nextInt();
                    initial[i][j] = num ;

                }
            }

            for(int i = 0 ; i < 4 ; i++)
            {
                for(int j = 0 ; j < 4 ; j++)
                {
                    // String input = scanner.nextLine();
                    int num = scanner.nextInt();
                    goal[i][j] = num ;

                }
            }

            int truefalse = sa.isSolvable(initial,goal);
            int x = -1;
            int y = -1;
            if(truefalse == 1)
            {
                PuzzleSolve ps = new PuzzleSolve();

                for(int i= 0;i<4;i++)
                {
                    for(int j=0;j<4;j++)
                    {
                        if(initial[i][j]==0)
                        {
                            x = i;
                             y = j;
                        }
                    }
                }
                System.out.println("Running Misplaced tiles heuristics: ");
                ps.AStarSearch(initial,goal,x,y,1);
                System.out.println("Running Manhattan distance heuristics: ");
                ps.AStarSearch(initial,goal,x,y,2);
            }



        }

}
