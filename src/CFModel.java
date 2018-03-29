/**
 *
 * @author Amine Moukrem
 * IST 311
 * October 25th 2017
 */
public class CFModel {
    static CFController controller;
    static CFView view;
    
    static char[][] cfGrid = new char[6][7];
            
    /*
        Checks if all spots are filled.
    */
    public static boolean checkTie(char[][] cfGrid) {
        for (int i = 0; i < cfGrid[0].length; i++) {
            if (cfGrid[0][i] == 0) {
                return false;
            }
        }
        return true;
    }
    
    /*
        Checks if there are 4 of the same discs to win
    */
    public static boolean gameIs(char[][] cfGrid, int column, char displayColor) {
        int row = 0;
        
        for (int i = 0; i < cfGrid.length; i++) {
            if (cfGrid[i][column] != 0) {
                row = i;
                break;
            }
        }
        
        if (checkColumn(cfGrid, column, displayColor, row)) {
            return true;
        }
        
        if (checkRow(cfGrid, column, displayColor, row)) {
            return true;
        }
        
        if (checkFirstDiag(cfGrid, column, displayColor, row)) {
            return true;
        }
        
        return checkOppositeDiag(cfGrid, column, displayColor, row);
    }
    
    // Checks diagonally for 4 tiles in a row
    public static boolean checkFirstDiag(char[][] cfGrid, int column, char displayColor, int row) {
        int counter = 1;
         
         for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (displayColor == cfGrid[i][j]) {
                counter++;
            }
            else {
                break;
            }
         }
         
         if (counter >= 4) {
             return true;
         }
         
         for (int i = row + 1, j = column + 1; i < cfGrid.length && j < cfGrid[0].length; i++, j++) {
             if (displayColor == cfGrid[i][j]) {
                 counter++;
             }
             else {
                 break;
             }
         }
         if (counter >= 4) {
             return true;
         }
         
         return false;
    }
    
    public static boolean checkOppositeDiag(char[][] cfGrid, int column, char displayColor, int row) {
        int counter = 1;
         
         for (int i = row + 1, j = column - 1; i < cfGrid.length && j >= 0; i++, j--) {
            if (displayColor == cfGrid[i][j]) {
                counter++;
            }
            else {
                break;
            }
         }
         
         if (counter >= 4) {
             return true;
         }
         
         for (int i = row - 1, j = column + 1; i >= 0 && j < cfGrid[0].length; i--, j++) {
             if (displayColor == cfGrid[i][j]) {
                 counter++;
             }
             else {
                 break;
             }
         }
         
         if (counter >= 4) {
             return true;
         }
         
         return false;
    }
    
    // Checks columns for 4 tiles in a row
     public static boolean checkColumn(char[][] cfGrid, int column, char displayColor, int row) {
         int counter = 1;
         
         if ((row + 4) <= 6) {
             for (int i = row + 1; i <= (row + 3); i++) {
                 if (displayColor == cfGrid[i][column]) {
                     counter++;
                 }
                 else {
                     break;
                 }
             }
         }
         
         if (counter == 4) {
             return true;
         }
         
         return false;
     }
     
     // Checks rows for 4 tiles in a row
     public static boolean checkRow(char[][] cfGrid, int column, char displayColor, int row) {
         int counter = 1;
         
         for (int i = column - 1; i >= 0; i--) {
            if (displayColor == cfGrid[row][i]) {
                counter++;
            }
            else {
                break;
            }
         }
         
         if (counter >= 4) {
             return true;
         }
         
         for (int i = column + 1; i < cfGrid[0].length; i++) {
             if (displayColor == cfGrid[row][i]) {
                 counter++;
             }
             else {
                 break;
             }
         }
         
         return false;
     }
    
    public static boolean dropDisc(char[][] cfGrid, int column, char displayColor) {
        for (int i = cfGrid.length - 1; i >= 0; i--) {
            if (cfGrid[i][column] == 0) {
                cfGrid[i][column] = displayColor;
                return false;
            }
        }
        System.out.println("Column is full.");
        return true;
    }
    
    public static char[][] getCFGrid() {
        return cfGrid;
    }
    
    public static void main (String args[]) {
        CFView.displayGrid(cfGrid);
        CFController.playConnectFour(cfGrid);
    }
}
