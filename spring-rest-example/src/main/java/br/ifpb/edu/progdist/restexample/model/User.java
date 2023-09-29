package br.ifpb.edu.progdist.restexample.model;

public class User {
    private int code;
    private String name;
    private int age;

    public User() {
    }

    public User(int code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "code=" + code + ", name=" + name + ", age=" + age + '}';
    }


}
