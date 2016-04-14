package org.revo.Inter;

import org.revo.Lexer.Word;
import org.revo.Symbols.Type;

public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }

    public String toString() {
        return "t" + number;
    }
}
