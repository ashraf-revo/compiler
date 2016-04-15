package org.revo.Compiler

import groovy.json.JsonOutput

/**
 * Created by ashraf on 4/15/2016.
 */
class Parser {

    Lexer lexer
    int index = 0;
    List<Token> tokens
    Block block = new Block("Main")

    Parser(Lexer lexer) {
        this.lexer = lexer
        tokens = lexer.scan()
    }

    Block block(Block current) {
        ShouldMatch(Tag.OpenBrace)
        Variable(current)
        Statement(current)
        ShouldMatch(Tag.CloseBrace)
        current
    }

    void Statement(Block current) {
        if (peak().tokenType == TokenType.Reserve) {
            if (peak().tag == Tag.If) {
                ShouldMatch(Tag.OpenParenthesis)
                current.add(block(new Block("If" + UUID.randomUUID().toString().replace("-", "").substring(5))))
                ShouldMatch(Tag.CloseParenthesis)
            }
        }
    }

    void Variable(Block current) {
        while (TokenType.Type == peak().tokenType) {
            current.add(new Block(NextPeak()))
            move()
            ShouldMatch(Tag.Semicolon)
        }
    }

    void parse() {

        println(JsonOutput.toJson(block(block)))
    }

    private void ShouldMatch(int tag) {
        if (tokens[index++].tag != tag) throw new Error("error in your code")
    }

    private Token peak() {
        tokens[index]
    }

    private Token NextPeak() {
        tokens[++index]
    }

    void move() {
        index++
    }
}
