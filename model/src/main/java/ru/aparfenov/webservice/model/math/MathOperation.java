package ru.aparfenov.webservice.model.math;

import javax.xml.bind.Marshaller;
import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
public abstract class MathOperation {
    public static final String TYPE_PARAM = "type";
    public static final String ARG_PARAM = "arg";
    protected Map<String, String> parameters;
    private Marshaller marshaller;
    public MathOperation(Map<String, String> params) {
        this.parameters = params;
    }
    abstract public String performOperation();
}
