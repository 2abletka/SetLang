package com.compiler.parser.sintaxtree;

public final class ContinueStatement extends RuntimeException implements Statement {

    @Override
    public void execute() {
        /*
         * Write to file
         * */
        Context.appendNewString("continue");
        Context.completeLine();

//        throw this;
    }
}
