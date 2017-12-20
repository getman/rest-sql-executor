package ru.aparfenov.webservice.model.math;

import ru.aparfenov.webservice.model.math.jaxb.MathOperationResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
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
        String returnVal = null;
        int result = param1 + param2;
        Marshaller jaxbMarshaller = null;
        StringWriter sw = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MathOperationResult.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MathOperationResult operResult = new MathOperationResult();
            operResult.setResult(String.valueOf(result));
            returnVal = "add result is:" + result;
            sw = new StringWriter();
            jaxbMarshaller.marshal(operResult, sw);
            returnVal += "/ sw is:" + sw.toString() + " / " + sw.getBuffer().toString();
        } catch (JAXBException e) {
            returnVal += e.getMessage();
            e.printStackTrace();
        }
        return returnVal;
    }

}
