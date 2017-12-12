package ru.aparfenov.webservice.db;

import ru.aparfenov.webservice.model.DbDao;

import javax.ejb.Local;

/**
 * Created by ArtemParfenov on 13.12.2017.
 */
@Local
public class OracleDaoBean implements DbDao {
    @Override
    public String executeQuery(String sqlQuery) {
        return "Responce from the Oracle DB";
    }

    @Override
    public boolean executeUpdate(String sqlQuery) {
        return false;
    }
}
