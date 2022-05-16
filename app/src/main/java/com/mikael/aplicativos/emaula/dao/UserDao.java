package com.mikael.aplicativos.emaula.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.mikael.aplicativos.emaula.model.entity.AddressEntity;
import com.mikael.aplicativos.emaula.model.entity.UserEntity;
import com.mikael.aplicativos.emaula.model.relation.UserWithAddressRelation;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER WHERE EMAIL = :email AND :password = :password")
    UserEntity login(String email, String password);

    @Transaction
    @Query("SELECT * FROM USER WHERE ID = :userId")
    LiveData<UserWithAddressRelation> loadUserWithAddress(String userId);

    @Insert
    void insert(UserEntity user);

    @Insert
    void insert(AddressEntity address);

    @Update
    void update(UserEntity user);

    @Update
    void update(AddressEntity address);

}