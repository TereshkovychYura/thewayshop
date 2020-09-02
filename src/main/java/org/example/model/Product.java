package org.example.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String Name;
    private String Category;
    private String Description;
    private double Price;
    private String Condition;
    private String Status;
    private String Manufacture;
    private boolean Wish;

    @Transient
    private MultipartFile Image;


    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setManufacture(String manufacture) {
        Manufacture = manufacture;
    }

    public void setWish(boolean wish) { Wish = wish; }

    public void setImage(MultipartFile image) { Image = image; }


    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return Price;
    }

    public String getCondition() {
        return Condition;
    }

    public String getStatus() {
        return Status;
    }

    public String getManufacture() {
        return Manufacture;
    }

    public boolean getWish() { return Wish; }

    public MultipartFile getImage() { return Image; }
}