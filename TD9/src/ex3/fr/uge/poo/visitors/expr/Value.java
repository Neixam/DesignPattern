package ex3.fr.uge.poo.visitors.expr;

public final class Value implements Expr {
    private final int value;

    public Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <E> E accept(ExprVisitor<E> exprVisitor) {
        return exprVisitor.visitValue(this);
    }
}
