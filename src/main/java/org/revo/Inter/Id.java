package org.revo.Inter;

import org.revo.Lexer.Word;
import org.revo.Symbols.Type;

public class Id extends Expr {

    public int offset;

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }

}
