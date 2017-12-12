package ru.aparfenov.webservice.model;

/**
 * Created by ArtemParfenov on 13.12.2017.
 */
public interface DbDao {
    /**Executes the specified SQL query and returns a result*/
    public String executeQuery(String sqlQuery);
    public boolean executeUpdate(String sqlQuery);
}
