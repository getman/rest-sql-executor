package ru.aparfenov.webservice.db;

import ru.aparfenov.webservice.model.DbDao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Locale;

/**
 * Created by ArtemParfenov on 13.12.2017.
 */

@Stateless
public class OracleDaoBean implements DbDao {
    @Resource(name="myOracleDataSource")
    private DataSource myDs;
    private Connection conn;

    public OracleDaoBean() {
    }

    @PostConstruct
    private void init() {
    }

    @Override
    public String executeQuery(String sqlQuery) {
        StringBuilder result = new StringBuilder();
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            Statement ps = conn.createStatement();
//            ResultSet rs = ps.executeQuery("select * from dual");
            ResultSet rs = ps.executeQuery(sqlQuery);
            while (rs.next()) {
                result.append(rs.getString(1));
            }
        } catch (SQLException e) {
            result.append("SQL exception while executing the query");
            result.append(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                result.append("SQL exception while trying to close the connection");
                result.append(e.getMessage());
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    @Override
    public boolean executeUpdate(String sqlQuery) {
        return false;
    }
}
