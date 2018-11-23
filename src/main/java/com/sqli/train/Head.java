package com.sqli.train;

class Head extends Wagon {

    public Head(boolean head) {
        if (!head){
            this.content="HHHH>";
        }else {
            this.content="<HHHH";
        }
    }
}
