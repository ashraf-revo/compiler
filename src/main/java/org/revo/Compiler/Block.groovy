package org.revo.Compiler

import groovy.transform.Canonical

/**
 * Created by ashraf on 4/15/2016.
 */
@Canonical
class Block {
    String name
    List<Block> blocks=[]
    Token token

    Block(name) {
        this.name = name
    }

    Block(Token token) {
        this.token = token
    }

    void add(Block) {
        blocks << Block
    }
}
