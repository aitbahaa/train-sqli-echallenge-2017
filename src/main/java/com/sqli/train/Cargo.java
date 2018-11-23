package com.sqli.train;

class Cargo extends Wagon {

    public Cargo() {
        this.content="|____|";
    }

    public boolean isEmpty() {
        return this.content.equals("|____|");
    }

    public void fill(){
        this.content="|^^^^|";
    }

}