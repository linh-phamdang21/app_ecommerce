package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


//    @NotEmpty
//    @Size(min = 4, max = 200)
//    @Pattern(regexp = "^$|[a-zA-Z0-9]*$")
    private String productName;

    private String image;
//    @NotEmpty
//    @Min(0)
    private float price;
//    @Size(min = 0, max = 200)
    private String describes;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ProductType type;

    public Product() {
    }

  public Product(String image,String productName,Float price,String describes,Category category,Brand band,ProductType productType){
        this.image=image;
        this.productName=productName;
        this.price=price;
        this.describes=describes;
        this.category=category;
        this.brand=band;
        this.type=productType;
  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductType getType(){
        return type;
    }

    public void setType(ProductType type){
        this.type = type;
    }

    @Transient
    private MultipartFile images;

    public void setImages(MultipartFile images) {
        this.images = images;
    }

    public MultipartFile getImages() {
        return images;
    }
}
