package ex2.fr.uge.poo.visitors.expr;

public class EvalExprVisitor implements ExprVisitor {
    @Override
    public int visitValue(Value value, StringBuilder stringBuilder) {
        return value.getValue();
    }

    @Override
    public int visitBinOp(BinOp binOp, StringBuilder stringBuilder) {
        return binOp.getOperator()
                .applyAsInt(visit(binOp.getLeft()), visit(binOp.getRight()));
    }

    public int visit(Expr expr) {
        return switch (expr) {
            case Value value -> visitValue(value, null);
            case BinOp binOp -> visitBinOp(binOp, null);
        };
    }
}