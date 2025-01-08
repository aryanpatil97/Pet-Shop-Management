package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCHandling {
		Connection con = null;
		PreparedStatement psmt = null;
		Statement stmt = null;
		
		
		JDBCHandling(){
		try {
			Class. forName("com.mysql.cj.jdbc.Driver");
			System.out.println("WOW : Driver Mil Gaya");
		}catch (ClassNotFoundException e) {
		 e.printStackTrace();
		System.out.println("Problem in loading Driver");
		}

	
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetShopManagement", "root", "password");
		System.out.println("WOW: Connection Ho gaya");
		} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Problem in Connection");
		}
}

int insertDog(String Name,String Breed,int Age,String Gender,String Vaccination) {
	int status = 0;
	try {
		psmt = con.prepareStatement("insert into Dogs values(default,?,?,?,?,?)");
		psmt.setString(1, Name);
		psmt.setString(2, Breed);
		psmt.setInt(3, Age);
		psmt.setString(4, Gender);
		psmt.setString(5, Vaccination);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
int insertCat(String Name,String Breed,int Age,String Gender,String Vaccination) {
	int status = 0;
	try {
		psmt = con.prepareStatement("insert into Cats values(default,?,?,?,?,?)");
		psmt.setString(1, Name);
		psmt.setString(2, Breed);
		psmt.setInt(3, Age);
		psmt.setString(4, Gender);
		psmt.setString(5, Vaccination);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/PetShopManagement"; // Update database name if needed
    String user = "root"; // Your MySQL username
    String password = "password"; // Your MySQL password
    return DriverManager.getConnection(url, user, password);
}

public static ResultSet getDogData(int Id) {
	 String query = "SELECT name, breed, age, vaccinated FROM Dogs WHERE id = ?";
     try {
         Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, Id);
         return pstmt.executeQuery(); // Return the ResultSet
     } catch (SQLException e) {
         e.printStackTrace();
         return null; // Return null in case of an error
     }
}
public static ResultSet getCatData(int Id) {
	 String query = "SELECT name, breed, age, vaccinated FROM Cats WHERE id = ?";
    try {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, Id);
        return pstmt.executeQuery(); // Return the ResultSet
    } catch (SQLException e) {
        e.printStackTrace();
        return null; // Return null in case of an error
    }
}
int insertUpdateDog(int Id,String Name,String Breed,int Age,String Gender,String Vaccination) {
	int status = 0;
	try {
		psmt = con.prepareStatement("update Dogs set name = ?,breed = ?,age = ?,gender = ?,vaccinated = ? where id = ? ");
		psmt.setString(1, Name);
		psmt.setString(2, Breed);
		psmt.setInt(3, Age);
		psmt.setString(4, Gender);
		psmt.setString(5, Vaccination);
		psmt.setInt(6, Id);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
int insertUpdateCat(int Id,String Name,String Breed,int Age,String Gender,String Vaccination) {
	int status = 0;
	try {
		psmt = con.prepareStatement("update Cats set name = ?,breed = ?,age = ?,gender = ?,vaccinated = ? where id = ? ");
		psmt.setString(1, Name);
		psmt.setString(2, Breed);
		psmt.setInt(3, Age);
		psmt.setString(4, Gender);
		psmt.setString(5, Vaccination);
		psmt.setInt(6, Id);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
int DeleteDog(int Id) {
	int status = 0;
	try {
		psmt = con.prepareStatement("delete from Dogs where id = ? ");
		psmt.setInt(1, Id);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
int DeleteCat(int Id) {
	int status = 0;
	try {
		psmt = con.prepareStatement("delete from Cats where id = ? ");
		psmt.setInt(1, Id);
		
		status = psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
}
