package clientarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class test {
public static void main(String arg[])
{
	try {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ods.setUser("SYSTEM");
		ods.setPassword("manager");
		Connection con = ods.getConnection();
		String q = "select *from TEST where NUM1=?";
		PreparedStatement st = con.prepareStatement(q);
		st.setInt(1,1);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			System.out.println("output" + rs.getInt("NUM2"));
		}
		
		System.out.println("ok");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("not ok");
		e.printStackTrace();
	}
}
}
