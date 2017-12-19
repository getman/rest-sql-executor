package ru.aparfenov.webservice.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.aparfenov.webservice.model.DbDao;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Restful service is responsible for getting SQL requests and answering with datasets or error traces
 * Created by ArtemParfenov on 12.12.2017.
 */
@WebServlet("/sql")
public class RestSqlService extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(RestSqlService.class);
    @EJB
    private DbDao dbDao;
    /**Receives SQL requests from clients to pass them to the database and returns dataset or error*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String query=req.getParameter("sql-query");
        log("query param sql-query:" + query);
        query = query != null ? query: "select * employee";
        if (logger.isDebugEnabled()) {
            logger.debug("SQL request is:" + query);
        }
        String responce = dbDao.executeQuery(query);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(responce);
        if (logger.isTraceEnabled()) {
            logger.trace("response is: " + responce);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}
