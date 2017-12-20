package ru.aparfenov.webservice.math;

import ru.aparfenov.webservice.model.math.MathOperation;
import ru.aparfenov.webservice.model.math.MathOperationFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Map;

/**
 * Created by AParfenov on 19.12.2017.
 */
@Stateless
@Local
public class MathOperationsBean {
    public MathOperationsBean() {
    }

    public String perform(String operType, Map parameters) {
        MathOperation mathOper = MathOperationFactory.createOperationByParams(operType, parameters);
        return mathOper.performOperation();
    }

}
