package com.compiler.parser.sintaxtree;

public final class BreakStatement extends RuntimeException implements Statement {

    @Override
    public void execute() {
        /*
         * Write to file
         * */
        Context.appendNewString("break");
        Context.completeLine();

//        throw this;
    }
}
