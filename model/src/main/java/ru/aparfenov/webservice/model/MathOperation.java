package ru.aparfenov.webservice.model;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
//@Local
public abstract class MathOperation {
    public static final String TYPE_PARAM = "type";
    public static final String ARG_PARAM = "arg";
    protected Map<String, String> parameters;
    public MathOperation(Map<String, String> params) {
        this.parameters = params;
    }
//    private String result;
//    public void init(Map parameters);
    /*public void init(Map parameters) {
        this.parameters = parameters;
    }*/
    abstract public String performOperation();
//    abstract public String getResult();
    /*public String getResult() {
        return result;
    }*/
}
