package cn.errison.feature.demo.exception.chain;

public class Layer3Exception extends Exception {

    public Layer3Exception(String message, Throwable throwable){
        super( message, throwable);
    }
}
