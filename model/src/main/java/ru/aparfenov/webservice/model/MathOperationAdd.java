package ru.aparfenov.webservice.model;

import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
public class MathOperationAdd extends MathOperation {
    private int param1;
    private int param2;

    public MathOperationAdd(Map<String, String> params) {
        super(params);
        param1 = Integer.valueOf(this.parameters.get(MathOperation.ARG_PARAM + 0));
        param2 = Integer.valueOf(this.parameters.get(MathOperation.ARG_PARAM + 1));
    }

    @Override
    public String performOperation() {
        int result = param1 + param2;
        return String.valueOf(result);
    }
}
