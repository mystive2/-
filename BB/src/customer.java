import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class customer {
//	public static void main(String[] args) {
//		createTable();
//		createCustomer("Danny","123456789","MALE");
//		ArrayList<String> list = getCustomers();
//		for(String item: list) {
//			System.out.println(item);
//		}
//	}
	
	public static void createCustomer(String nametxt, String birth, String gender) {
		try {
			Connection con= getConnection();
			PreparedStatement insert=con.prepareStatement(""
						+"INSERT INTO customer"
						+"(name, birth, gender) "
						+ "VALUE "
						+ "('"+nametxt+"','"+birth+"','"+gender+"')");
			insert.execute();
			System.out.println("The data has been saved");
		}catch(Exception e) {
			
		}
	}
	
	public static String[][] getCustomers(){
		try {
			Connection con=getConnection();
			PreparedStatement statement=con.prepareStatement("Select name, birth, gender FROM customer");
			ResultSet results= statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("birth"),
						results.getString("gender")
				});
//				list.add("Name : "+ results.getString("name") +
//					   	" birth : "+ results.getString("birth")+ 
//					   	" gender : "+ results.getString("gender"));   			
			}
			System.out.println("The data has been fetched");
			String[][] arr=new String[list.size()][3];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createTable() {
		try {
			Connection con= getConnection();
			PreparedStatement createTable=con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255), "
					+ "birth varChar(255), "
					+ "gender varChar(255), "
					+ "PRIMARY KEY(id))");
			createTable.execute();
			System.out.println("succes create table");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12378570";
			String user = "sql12378570";
			String pass = "KKxG4a74by";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
