package cn.errison.serialization;

import java.io.*;

public class Employee implements Serializable {

    // 此项必须有
    private static final long serialVersionUID = 1L;

    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

    private void serializeMethod() {
        Employee employee = new Employee();
        employee.name = "Reyan Ali";
        employee.address = "Phokka Kuan, Ambehta Peer";
        employee.SSN = 11122333;
        employee.number = 101;
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("d://test.obj");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in d://test.obj");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void deSerializeMethod() {
        Employee employee = null;
        try {
            File file = new File("d:\\test.obj");
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employee = (Employee) in.readObject();
            in.close();
            fileIn.close();
            file.delete();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + employee.name);
        System.out.println("Address: " + employee.address);
        System.out.println("SSN: " + employee.SSN);
        System.out.println("Number: " + employee.number);
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.serializeMethod();
        employee.deSerializeMethod();
    }
}
