package model;

public class Subject {
    private int id;
    private String code, name;
    private int credit;  //so tin chi cua mon hoc

    public Subject() {
    }

    public Subject(int id, String code, String name, int credit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
