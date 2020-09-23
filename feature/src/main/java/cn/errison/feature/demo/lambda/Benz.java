package cn.errison.feature.demo.lambda;

class Benz implements Car {

    private String name;

    public Benz(String string){
        this.name = string;
    }

    public String move(){
        return this.name + " is moving";
    }

    public static void engineStart(){
        System.out.println("engine is start!");
    }
}
