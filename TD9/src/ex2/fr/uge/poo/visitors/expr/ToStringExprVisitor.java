package ex2.fr.uge.poo.visitors.expr;

public class ToStringExprVisitor implements ExprVisitor {

    @Override
    public int visitValue(Value value, StringBuilder stringBuilder) {
        return 0;
    }

    @Override
    public int visitBinOp(BinOp binOp, StringBuilder stringBuilder) {
        stringBuilder.append( binOp.getOpName());
        return 0;
    }
}
