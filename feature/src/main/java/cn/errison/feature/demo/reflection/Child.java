package cn.errison.feature.demo.reflection;

class Child extends Person implements ActionInterface {

    private boolean childFields;

    public void fly() {
        System.out.println("define fly method in ");
    }

    public boolean isChildFields() {
        return childFields;
    }

    public void setChildFields(boolean childFields) {
        this.childFields = childFields;
    }

    @Override
    public void walk(int m) {
        System.out.println("override walk method in Child");
    }
}
