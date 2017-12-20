package ru.aparfenov.webservice.model.math.jaxb;

import javax.xml.bind.annotation.*;

/**
 * Created by AParfenov on 20.12.2017.
 */
@XmlRootElement(name = "MathOperationResult")
public class MathOperationResult {
    private String operationComment;
    private String result;

    /**Default конструктор.*/
    public MathOperationResult() {
    }

    public void setOperationComment(String operationComment) {
        this.operationComment = operationComment;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @XmlElement(name = "OperationComment")
    public String getOperationComment() {
        return operationComment;
    }

    @XmlElement(name = "Result")
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "MathOperationResult{"
                + "operationComment='" + operationComment + '\''
                + ",result='" + result + '\''
                + '}';
    }
}
