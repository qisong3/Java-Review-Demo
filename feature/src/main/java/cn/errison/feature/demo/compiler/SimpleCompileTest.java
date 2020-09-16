package cn.errison.feature.demo.compiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleCompileTest {

    private void compileClass(String name) throws IOException {

        String filePath = System.getProperty("user.dir") + "\\feature\\src\\main\\java\\cn\\errison\\feature\\demo\\compiler\\" + name;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, System.out, new FileOutputStream(new File("error.txt")), filePath);
        if (compilationResult == 0) {
            System.out.println("Compilation is successful");
        } else {
            System.out.println("Compilation Failed");
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleCompileTest test = new SimpleCompileTest();
        test.compileClass("Demo.java");
    }
}