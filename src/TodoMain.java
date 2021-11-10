import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class TodoMain {
	public TodoMain() { 
		items = Database.getTodoItems();
		frame = new CreateFrame(items);
	}
	
	ArrayList<Item> items;
	CreateFrame frame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new TodoMain();
            }
        });
	}

}
