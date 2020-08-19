package cn.errison.feature.demo.exception.chain;

public class Layer2Exception extends Exception {

    public Layer2Exception(String message, Throwable throwable){
        super(message, throwable);
    }
}
