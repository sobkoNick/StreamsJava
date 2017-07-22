package com.epam.lab.ioTask.coment;

/**
 * simple person class
 */

/*****
 * Another common multi-line comment style.
 */

public class ClassWithComents {
    private String name; // person name
    private int age; // person age

    // person talks
    public String talk() {
        return "Hi!";
    }

    public String talkStrangly() {
        return "asd / /* ** bla " +
                "bla /// /* *** */";
    }

    /* some comment*/

    // returns name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }

//    public void setAge(int age) {
//        this.age = age;
//    }
}
