package com.mikael.aplicativos.emaula.model.relation;


import androidx.room.Embedded;
import androidx.room.Relation;

import com.mikael.aplicativos.emaula.model.entity.AddressEntity;
import com.mikael.aplicativos.emaula.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserWithAddressRelation {

    @Embedded
    private UserEntity user;

    @Relation(
            parentColumn = "id",
            entityColumn = "userId"
    )
    private List<AddressEntity> addressList;

    public UserWithAddressRelation() {
        this.addressList = new ArrayList<>();
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<AddressEntity> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
    }
}
