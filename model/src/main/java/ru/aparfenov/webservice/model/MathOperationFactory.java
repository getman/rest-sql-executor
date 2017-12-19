package ru.aparfenov.webservice.model;

import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
public abstract class MathOperationFactory {
    public static final String OPER_ADD = "add";
    public static final String OPER_SUB = "sub";

    public static MathOperation createOperationByParams(String operType, Map<String, String> parameters) {
        MathOperation oper = null;
        switch (operType) {
            case OPER_ADD:
                oper = new MathOperationAdd(parameters);
                break;
            case OPER_SUB:
                break;
        }
        return oper;
    }
}
