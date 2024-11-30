package database;

import java.sql.*; 

public class Connect {
	
//	1. SET ATTRIBUTE UTK MENAMPUNG INFO DASAR UTK CONNECT PROGRAM KT KE DB (VARIABLE KONSTANTA) 
	private final String USERNAME = "root"; 
	private final String PASSWORD = ""; 
	private final String DATABASE = "chillflix"; 
	private final String HOST = "localhost: 3306"; 
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE); 
	
//	2. SET ATTRIBUTE UTK OBJECT SQL 
	public ResultSet rs; // utk nampung data hasil query select 
	public ResultSetMetaData rsm; //buat nampung meta data dari hasil query kt 
	private Connection con; 
	private Statement st; // utk nampung statement buat execute query sql (select, insert, update) 
	
//	3. BIKIN CONSTRUCTOR 
	private Connect() {
//		set driver mysql ke dalam memory 
//		driver -> jembatan antara program kt dengan db nya 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); 
			st = con.createStatement(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
//	4. IMPLEMENTASI DARI SINGLETON PATTERNYA 
	private static Connect connect = null; 
	public static Connect getInstance() {
		if (connect == null) {
			connect = new Connect(); 
		}
		return connect; 
	}
	
//	5. SELECT DATA -> disimpen di variable rs 
	public ResultSet execQuery(String Query) {
		try {
			rs = st.executeQuery(Query);
			rsm = rs.getMetaData(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs; 
	}
	
//	6. UPDATE / MANIPULASI DATA (INSERT, UPDATE, DELETE) 
	public void execUpdate(String Query) {
		try {
			st.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
//	7. Prepared statement 
	public PreparedStatement preparedStatement(String query) {
		PreparedStatement ps = null; 
		
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return ps; 
	}
	
	
	
}
