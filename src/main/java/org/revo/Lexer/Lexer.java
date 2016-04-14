package org.revo.Lexer;

import org.revo.Symbols.Type;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {

    public static int line = 1;
    char peek = ' ';
    Hashtable<String, Word> words = new Hashtable<String, Word>();

    void reserve(Word w) {
        words.put(w.lexeme, w);

    }

    public Lexer() {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Float);
        reserve(Type.Bool);
    }

    void readChar() throws IOException {
        peek = (char) System.in.read();
    }

    boolean readChar(char c) throws IOException {
        readChar();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; readChar()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line++;
            } else {
                break;
            }
        }

        switch (peek) {
            case '&':
                if (readChar('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readChar('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readChar('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readChar('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readChar('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readChar('=')) {
                    return Word.ge;
                } else {
                    return new Token('>');
                }

        }

        if (Character.isDigit(peek)) {
            int val = 0;
            do {
                val = val * 10 + Character.digit(peek, 10);
                readChar();
            } while (Character.isDigit(peek));

            if (peek != '.') {
                return new Num(val);
            }
            float fl = val;
            float d = 10;
            for (; ; ) {
                readChar();
                if (!Character.isDigit(peek)) {
                    break;
                }
                fl = fl + Character.digit(peek, 10) / d;
                d *= 10;
            }
            return new Real(fl);

        }

        if (Character.isLetter(peek)) {
            StringBuilder buffer = new StringBuilder();
            do {
                buffer.append(peek);
                readChar();
            } while (Character.isLetterOrDigit(peek));
            String s = buffer.toString();
            Word word = words.get(s);
            if (word != null) {
                return word;
            }
            word = new Word(s, Tag.ID);
            words.put(s, word);
            return word;

        }
        Token token = new Token(peek);
        peek = ' ';
        return token;
    }
}
