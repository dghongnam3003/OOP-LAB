package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
        JOptionPane.showMessageDialog(null, "You have chosen: " + (option == JOptionPane.YES_OPTION? "Co":"Khong"));
        System.exit(0);
    }
}


/* Question:
	
-	What happens if users choose “Cancel”?
Answer: If users choose "Cancel", It will print "You've chosen: No"

-	How to customize the options to users, e.g. only two options: “Yes” and “No”, OR “I do” and “I don’t” (Suggestion: Use Javadocs or using Eclipse/Netbean IDE help). 
Answer: Change the option variable:
          int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_OPTION);
 */