import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connector {

	static Connection connection = null;
	static Statement statement = null;  
	static ResultSet resultSet = null;
	
	public static ArrayList<Item> getItems(String url, String user, String pw){
		ArrayList<Item> items = new ArrayList<Item>();
		
		try{
	        connection = DriverManager.getConnection(url, user, pw);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("SELECT * FROM items");
	        
	        while (resultSet.next()) {
	        	Item item = new Item(resultSet.getString("item"), resultSet.getBoolean("itemState"));
	        	System.out.println(item.getItem());
				items.add(item);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
			if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
		    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		    
		}
		
		return items;
	}
}
