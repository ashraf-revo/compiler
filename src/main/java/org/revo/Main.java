package org.revo;

import org.revo.Lexer.Lexer;
import org.revo.Lexer.Token;
import org.revo.Parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        System.out.println(lexer.scan().toString());
        System.out.println(lexer.scan().toString());
        System.out.println(lexer.scan().toString());

//        Parser parser = new Parser(lexer);
//        parser.program();
    }

}
