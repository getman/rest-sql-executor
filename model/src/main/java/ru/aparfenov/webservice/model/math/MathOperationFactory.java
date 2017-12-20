package ru.aparfenov.webservice.model.math;

import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
public abstract class MathOperationFactory {
    /**substraction operation*/
    public static final String OPER_SUB = "sub";
    /**addition operation*/
    public static final String OPER_ADD = "add";
    /**multiplication operation*/
    public static final String OPER_MULT = "mult";
    /**division operation*/
    public static final String OPER_DIV = "div";

    public static MathOperation createOperationByParams(String operType, Map<String, String> parameters) {
        MathOperation oper = null;
        switch (operType) {
            case OPER_ADD:
                oper = new MathOperationAdd(parameters);
                break;
            case OPER_SUB:
                oper = new MathOperationSub(parameters);
                break;
            case OPER_MULT:
                oper = new MathOperationMult(parameters);
                break;
            case OPER_DIV:
                oper = new MathOperationDiv(parameters);
                break;
        }
        return oper;
    }
}
