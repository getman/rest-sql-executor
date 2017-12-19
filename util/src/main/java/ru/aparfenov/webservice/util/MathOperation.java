package ru.aparfenov.webservice.util;

/**
 * Created by AParfenov on 19.12.2017.
 */
public interface MathOperation<T> {
    public void performOperation();
    public T getResult();
}
