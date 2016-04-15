package org.revo.Compiler

/**
 * Created by ashraf on 4/15/2016.
 */
class Main {
    public static void main(String[] args) {
        Lexer lexer = new LexerImpl("C:\\Users\\ashraf\\Desktop\\compiler\\src\\main\\resources\\code1");
        Parser parser = new Parser(lexer)
        parser.parse()

    }
}
