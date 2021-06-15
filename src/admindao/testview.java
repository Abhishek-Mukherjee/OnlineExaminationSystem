package admindao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testview {

	public static void main(String[] args) {
		Dao obj= new Dao();
		ResultSet r = obj.viewexam("tcs0102");
		try {
			r.next();
			System.out.println(r.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
