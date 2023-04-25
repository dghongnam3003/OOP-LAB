import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
        JOptionPane.showMessageDialog(null, "You have chosen: " + (option == JOptionPane.YES_OPTION? "Co":"Khong"));
        System.exit(0);
    }
}


/* Question:
	- If users choose "Cancel", the screen will display the pop-up "You have chosen: No"
	- Customize the "YES_OPTON" elements.
 */