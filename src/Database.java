import java.util.ArrayList;

public class Database extends Connector{

	public ArrayList<String> getTodoItems() {
		
		Connector connector = new Connector();

		ArrayList<String> items = new ArrayList<String>();
		
		String url1 = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String password = "qwerty1234";
		
		items = connector.getItems(url1, user, password);

		return items;
	}
}
