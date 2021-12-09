package ex3.fr.uge.poo.visitors.expr;

public class ToStringExprVisitor implements ExprVisitor<String> {
    private final StringBuilder tostring = new StringBuilder();
    @Override
    public String visitValue(Value value) {
        return String.valueOf(value.getValue());
    }

    @Override
    public String visitBinOp(BinOp binOp) {
        return tostring.append("(")
                .append(binOp.getLeft().accept(new ToStringExprVisitor()))
                .append(' ')
                .append(binOp.getOpName())
                .append(' ')
                .append(binOp.getRight().accept(new ToStringExprVisitor()))
                .append(")").toString();
    }
}
