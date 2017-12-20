package ru.aparfenov.webservice.rest.math;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.aparfenov.webservice.math.MathOperationsBean;
import ru.aparfenov.webservice.model.math.MathOperation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
@WebServlet("/oper")
public class RestMathService extends HttpServlet {
    @EJB
    private MathOperationsBean mathBean;

    private static final Logger logger = LogManager.getLogger(RestMathService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String operationType = req.getParameter(MathOperation.TYPE_PARAM);
        String argI = null;
        int i = 0;
        Map<String, String> parameters = new HashMap();
        while ((argI = req.getParameter(MathOperation.ARG_PARAM + i)) != null) {
            parameters.put(MathOperation.ARG_PARAM + i, req.getParameter(MathOperation.ARG_PARAM + i));
            i++;
        }
        log("math oper parameters:" + parameters + ", oper type:" + operationType);
        String responce;
        if (!parameters.isEmpty()) {
            responce = mathBean.perform(operationType, parameters);
            log("responce is:" + responce);
        } else {
            responce = "nothing";
        }
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
