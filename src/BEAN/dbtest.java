package BEAN;


import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class dbtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("manager");
			Connection con = ods.getConnection();
			String Q = "SELECT * FROM test";
			String Q1 = "SELECT * FROM test WHERE NUM1=?";
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery(Q);
			while(rs1.next())
			{
				System.out.println(rs1.getInt(1)+"  "+rs1.getInt(2));
			}
			
			PreparedStatement pstm = con.prepareStatement(Q1);
			pstm.setInt(1, 3);
			
			//pstm.setString(parameterIndex, x);
			
			ResultSet rs = pstm.executeQuery();
			
			//int variable_name = pstm.executeUpdate();
			
			System.out.println("");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getInt(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not ok");
		}
	}

}
