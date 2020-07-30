import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqldbTest {

    @Test
    public void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            conn = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE t_user (" +
                    "id BIGINT NOT NULL, " +
                    "name VARCHAR(20) NOT NULL," +
                    "password VARCHAR(32) NOT NULL, " +
                    "age SMALLINT, " +
                    "birthday TIMESTAMP," +
                    "PRIMARY KEY (id)" +
                    ");";

            System.out.println(sql);

            int result = stmt.executeUpdate(sql);

            System.out.println("result:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInsert() {
        createTable();

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            conn = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
            stmt = conn.createStatement();
            int result = stmt.executeUpdate("INSERT INTO t_user VALUES (1,'ricky', '12345', 28, '1989-09-15 15:00:00');");
            System.out.println("result:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
