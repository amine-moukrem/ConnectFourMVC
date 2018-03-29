/**
 *
 * @author Amine Moukrem
 * IST 311
 * October 25th 2017
 */
import java.util.Scanner;

public class CFController {
    static CFModel model;
    static CFView view;
    public static void playConnectFour(char[][] cfGrid) {
        Scanner input = new Scanner(System.in);
        boolean playerWin = false;
        boolean redTurn = true;
        int column = 0;
        char displayColor;
        
        while (!playerWin) {
            if (redTurn) {
                System.out.print("Insert red disc in columns 0 to 6: ");
                displayColor = 'R';
            }
            else {
                System.out.print("Insert black disc in columns 0 to 6: ");
                displayColor = 'B';
            }
            
            column = input.nextInt();
            
            while (column < 0 || column > 6) {
                System.out.println("Column # must be between 0 to 6, try again: ");
                column = input.nextInt();
            }
            redTurn = !redTurn;
            if (CFModel.dropDisc(cfGrid, column, displayColor)){
               redTurn = !redTurn; 
            }
            else {
                view.displayGrid(cfGrid);
                
                if (model.gameIs(cfGrid, column, displayColor)) {
                    playerWin = true;
                    if (displayColor == 'R') {
                        System.out.println("Player RED wins!");
                    }
                    else if (displayColor == 'B') {
                        System.out.println("Player BLACK wins!");
                    }
                    else if (model.checkTie(cfGrid)) {
                    playerWin = true;
                    System.out.print("Game is tied.");
                }
                }
            }
        }
        input.close();
    }
}
