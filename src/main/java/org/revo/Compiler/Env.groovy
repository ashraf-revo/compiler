package org.revo.Compiler

import groovy.transform.Canonical

/**
 * Created by ashraf on 4/15/2016.
 */
@Canonical
class Env {
    List<Token> vars=[]
    Env previous

    Env(Env env) {
        previous = env
    }

    void add(Token token) {
        vars << token
    }
}
