package org.revo.Inter;

import org.revo.Lexer.Num;
import org.revo.Lexer.Token;
import org.revo.Lexer.Word;
import org.revo.Symbols.Type;

public class Constant extends Expr {

    public Constant(Token token, Type p) {
        super(token, p);
    }

    public Constant(int i) {
        super(new Num(i), Type.Int);
    }

    public static final Constant
            True = new Constant(Word.True, Type.Bool),
            False = new Constant(Word.False, Type.Bool);

    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }

}
