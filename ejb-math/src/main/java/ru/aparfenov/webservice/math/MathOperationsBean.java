package ru.aparfenov.webservice.math;

import ru.aparfenov.webservice.model.MathOperation;
import ru.aparfenov.webservice.model.MathOperationFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
@Stateless
@Local
//public class MathOperationsBean implements MathOperation {
public class MathOperationsBean {
    MathOperation mathOper;
    public MathOperationsBean() {
    }

    public void init(String operType,Map parameters) {
//        String operType = (String) parameters.get(MathOperation.TYPE_PARAM);
        mathOper = MathOperationFactory.createOperationByParams(operType, parameters);
    }

    public String performOperation() {
        return mathOper.performOperation();
    }

}
