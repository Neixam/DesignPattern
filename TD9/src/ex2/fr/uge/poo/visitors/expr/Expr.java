package ex2.fr.uge.poo.visitors.expr;

import java.util.Iterator;

public sealed interface Expr permits BinOp, Value {
    <E> E accept(ExprVisitor<E> exprVisitor);

    public static Expr parseExpr(Iterator<String> it) {
        if (!it.hasNext()) {
            throw new IllegalArgumentException("no more tokens");
        }
        String token = it.next();
        switch(token) {
            case "+":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a + b);
            case "-":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a - b);
            case "*":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a * b);
            case "/":
                return new BinOp(parseExpr(it), parseExpr(it), token, (a, b) -> a / b);
            default:
                return new Value(Integer.parseInt(token));
        }
    }

}
