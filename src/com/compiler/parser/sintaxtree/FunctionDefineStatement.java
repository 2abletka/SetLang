package com.compiler.parser.sintaxtree;

import com.compiler.variables.Functions;
import com.compiler.variables.UserDefinedFunction;

import java.util.List;

public final class FunctionDefineStatement implements Statement {

    private final String name;
    private final List<String> argNames;
    private final Statement body;

    public FunctionDefineStatement(String name, List<String> argNames, Statement body) {
        this.name = name;
        this.argNames = argNames;
        this.body = body;
    }

    @Override
    public void execute() {
        Functions.set(name, new UserDefinedFunction(argNames, body));

        /*
         * Write to file
         * */
        Context.setContextStream(false);
        Context.appendNewString("private static void " + name + "(");
//        Args
        int counter = 0;
        for (String arg : argNames) {
            if (counter == 0) {
                Context.appendCurrentString("Double " + arg);
            } else {
                Context.appendCurrentString(", Double " + arg);
            }
            counter++;
        }
        Context.appendCurrentString(") {");
//        Body
        body.execute();
        Context.appendNewString("}");
        Context.setContextStream(true);
    }
}
