package ex3.fr.uge.poo.visitors.expr;

import java.util.function.Function;

public class ExprVisitor<E> {
    private Function<Expr, E> binOpFun;
    private Function<Expr, E> valueFun;
    public ExprVisitor<E> when(Class<Expr> clazz, Function<Expr, E> function) {
        if (clazz.equals(BinOp.class)) {
            binOpFun = function;
        } else {
            valueFun = function;
        }
        return this;
    }
}