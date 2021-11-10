import java.util.ArrayList;

public class Database extends Connector{

	public static ArrayList<Item> getTodoItems() {
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		String url1 = "jdbc:mysql://localhost:3306/dbkk";
        String user = "root";
        String password = "qwerty1234";
		
		items = getItems(url1, user, password);
		
		return items;
	}
}
