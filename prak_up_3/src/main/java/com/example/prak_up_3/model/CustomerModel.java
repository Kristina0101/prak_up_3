package com.example.prak_up_3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(max = 100, message = "Имя должно содержать не более 100 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email не должен быть пустым")
    @Size(max = 100, message = "Email должен содержать не более 100 символов")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 20, message = "Телефон должен содержать не более 20 символов")
    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
