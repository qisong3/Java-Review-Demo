package cn.errison.feature.demo.exception.chain;

public class BusService {

    private static void throwLayer1Exception() throws Layer1Exception{
        throw new Layer1Exception("this is layer1 excption", null);
    }

    private static void throwLayer2Exception() throws Layer2Exception{
        try {
            throwLayer1Exception();
        }catch (Layer1Exception e){
            throw new Layer2Exception("this is layer2 exception", e);
        }
    }

    private static void throwLayer3Exception() throws Layer3Exception{
        try {
            throwLayer2Exception();
        }catch (Layer2Exception e){
            throw new Layer3Exception("this is layer3 exception", e);
        }
    }

    private static void catchAllException()  {
        try {
            throwLayer3Exception();
        }catch (Layer3Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        catchAllException();
    }
}
