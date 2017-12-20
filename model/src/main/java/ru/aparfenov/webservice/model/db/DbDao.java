package ru.aparfenov.webservice.model.db;

import javax.ejb.Local;

/**
 * Created by ArtemParfenov on 13.12.2017.
 */
@Local
public interface DbDao {
    /**Executes the specified SQL query and returns a result*/
    public String executeQuery(String sqlQuery);
    public boolean executeUpdate(String sqlQuery);
}
