package model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private int id;
    private String name;
    private String address;
    private int class_id;
    private MultipartFile avatar;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentForm(String name, String address) {
        this.name = name;
        this.address = address;
    }



    public StudentForm(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public StudentForm() {
    }


    public StudentForm(String name, String address, int class_id) {
        this.name = name;
        this.address = address;
        this.class_id = class_id;
    }

    public StudentForm(String name, String address, int class_id, MultipartFile avatar) {
        this.name = name;
        this.address = address;
        this.class_id = class_id;
        this.avatar = avatar;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}