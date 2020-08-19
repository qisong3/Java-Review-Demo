package cn.errison.feature.demo.exception.chain;

public class Layer1Exception extends Exception {

    public Layer1Exception(String message, Throwable throwable){
        super(message, throwable);
    }
}
