package com.mikael.aplicativos.emaula.model.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import lombok.NonNull;

@Entity(tableName = "address")
public class AddressEntity implements Serializable {

    @NonNull
    @PrimaryKey
    private String id;
    private String userId;
    private String publicPlace;
    private String complement;
    private String number;
    private String state;
    private String city;
    private String cep;
    private String country;

    public AddressEntity(String userId, String publicPlace, String complement, String number, String state, String city, String cep, String country) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.publicPlace = publicPlace;
        this.complement = complement;
        this.number = number;
        this.state = state;
        this.city = city;
        this.cep = cep;
        this.country = country;
    }

    @Ignore
    public AddressEntity() {
        this("", "", "", "", "", "", "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
