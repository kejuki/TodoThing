import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class TodoMain {
	public TodoMain() { 
		items = new ArrayList<String>();
		db = new Database();
		items = db.getTodoItems();
		frame = new CreateFrame(items);
	}
	
	ArrayList<String> items;
	Database db;
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
