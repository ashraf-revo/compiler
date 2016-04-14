package org.revo.Inter;

import org.revo.Lexer.Token;
import org.revo.Symbols.Type;

public class Unary extends Op {

    public Expr expr;

    public Unary(Token token, Expr x) {
        super(token, null);
        expr = x;
        type = Type.maxSize(Type.Int, expr.type);
        if (type == null) {
            error("type error");
        }
    }

    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    public String toString() {
        return op.toString() + " " + expr.toString();
    }

}
