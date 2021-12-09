package ex2.fr.uge.poo.visitors.expr;

public interface ExprVisitor {
    int visitValue(Value value, StringBuilder stringBuilder);
    int visitBinOp(BinOp binOp, StringBuilder stringBuilder);
}