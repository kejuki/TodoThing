import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connector {

	Connection connection = null;
	Statement statement = null;  
	ResultSet resultSet = null;
	
	public ArrayList<String> getItems(String url, String user, String pw){
		ArrayList<String> items = new ArrayList<String>();
		
		try{
	        connection = DriverManager.getConnection(url, user, pw);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("SELECT * FROM items");
	        
	        while (resultSet.next()) {
				items.add(resultSet.getString("item"));
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
