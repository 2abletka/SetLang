package com.compiler.parser.sintaxtree;

public class WhileStatement implements Statement {
    private final Expression condition;
    private final Statement statement;

    public WhileStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void execute() {
        /*
         * Write to file
         * */
        Context.appendNewString("while " + condition + " {");
        statement.execute();
        Context.appendNewString(" }");

//        while (condition.evaluate().asNumber() != 0) {
//            try {
//                statement.execute();
//            } catch (BreakStatement e) {
//                break;
//            } catch (ContinueStatement e) {
//                continue;
//            }
//        }
    }
}
