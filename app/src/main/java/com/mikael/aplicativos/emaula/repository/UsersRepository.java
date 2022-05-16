package com.mikael.aplicativos.emaula.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.mikael.aplicativos.emaula.dao.UserDao;
import com.mikael.aplicativos.emaula.database.AppDatabase;
import com.mikael.aplicativos.emaula.model.entity.AddressEntity;
import com.mikael.aplicativos.emaula.model.entity.UserEntity;
import com.mikael.aplicativos.emaula.model.relation.UserWithAddressRelation;

public class UsersRepository {

    private UserDao userDao;

    public UsersRepository(Application app) {
        userDao = AppDatabase.getInstance(app).userDao();
    }

    public UserEntity login(String email, String password) {
        return userDao.login(email, password);
    }

    public LiveData<UserWithAddressRelation> loadUserWithAddress(String userId) {
        return loadUserWithAddress(userId);
    }

    public void insert(UserEntity user) {
        userDao.update(user);
    }

    public void insert(AddressEntity address) {
        userDao.update(address);
    }

    public void update(UserEntity user) {
        userDao.update(user);
    }

    public void update(AddressEntity address) {
        userDao.update(address);
    }

}
