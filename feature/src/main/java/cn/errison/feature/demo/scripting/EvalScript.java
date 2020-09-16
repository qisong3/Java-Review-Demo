package cn.errison.feature.demo.scripting;

import javax.script.*;

public class EvalScript {

    public static void main(String[] args) {

        try{
            // Create an instance of the Scripting manager.
            ScriptEngineManager manager = new ScriptEngineManager();

            // Get the reference to the rhino scripting engine.
            ScriptEngine rhinoEngine = manager.getEngineByName("javascript");

            // Get the Binding object for this Engine.
            Bindings bindings =	rhinoEngine.getBindings(ScriptContext.ENGINE_SCOPE);

            // Put the input value to the Binding.
            bindings.put("strValue", "A Test String");

            // Populate the script code to be executed.
            StringBuilder scriptCode = new StringBuilder();
            scriptCode.append("var javaString = new java.lang.String(strValue);");
            scriptCode.append("var result = javaString.length();");

            // Evaluate the Script code.
            rhinoEngine.eval(scriptCode.toString());

            // Take the output value from the script, i.e from the Bindings.
            int strLength = (Integer)bindings.get("result");

            System.out.println("Length is " + strLength);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}