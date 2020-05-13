package com.compiler.parser.sintaxtree;

import com.compiler.variables.NumberValue;
import com.compiler.variables.StringValue;
import com.compiler.variables.Value;

public final class PrintStatement implements Statement {
    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        Value expressionValue = expression.evaluate();
        String expressionToString = expression.toString();
        Context.appendNewString("System.out.print(");
        if (expressionValue instanceof NumberValue) {
            Context.appendCurrentString(expressionToString);
        } else if (expressionValue instanceof StringValue) {
            Context.appendCurrentString("\"");
            if (expressionToString.equals("\n")) {
                Context.appendCurrentString("\\n");
            } else {
                Context.appendCurrentString(expression.toString());
            }
            Context.appendCurrentString("\"");
        }
        Context.appendCurrentString(")");
        Context.completeLine();
    }

    @Override
    public String toString() {
        return "print " + expression;
    }
}
