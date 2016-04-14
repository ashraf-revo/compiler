package org.revo.Inter;

import org.revo.Lexer.Token;
import org.revo.Symbols.Type;

public class Op extends Expr{

    public Op(Token token, Type p){
        super(token,p);
    }

    public Expr reduce(){
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString()+" = "+x.toString());
        return t;
    }

}
