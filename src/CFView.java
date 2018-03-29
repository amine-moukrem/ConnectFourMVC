/**
 *
 * @author Amine Moukrem
 * IST 311
 * October 25th 2017
 */
public class CFView {
    static CFController controller;
    static CFModel model;
    
    public static void displayGrid(char[][] cfGrid) {
        for (int i = 0; i < model.getCFGrid().length; i++) {
            for (int j = 0; j < model.getCFGrid()[i].length; j++) {
                System.out.print("| " + model.getCFGrid()[i][j]);
            }
            System.out.println("| ");
        }
    }
}
