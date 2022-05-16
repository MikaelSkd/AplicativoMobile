package com.mikael.aplicativos.emaula.view.model;

import android.app.Application;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mikael.aplicativos.emaula.model.entity.UserEntity;
import com.mikael.aplicativos.emaula.model.relation.UserWithAddressRelation;
import com.mikael.aplicativos.emaula.repository.UsersRepository;

import java.util.Optional;

public class UserViewModel extends AndroidViewModel {

    public static final String USER_ID = "USER_ID";

    private UsersRepository usersRepository;


    public UserViewModel(@NonNull Application application) {
        super(application);

        usersRepository = new UsersRepository(application);
    }

    public void createUser(UserEntity user) {
        usersRepository.insert(user);
    }

    public MutableLiveData<UserEntity> login(String email, String password){
        Optional<UserEntity> user = Optional.ofNullable(
                usersRepository.login(email, password)
        );
        if (user.isPresent()) {
            PreferenceManager.getDefaultSharedPreferences(getApplication())
                    .edit()
                    .putString(USER_ID, user.get().getId())
                    .apply();
            return new MutableLiveData<>(user.get());
        }

        return new MutableLiveData<>(null);
    }

    public void logout(){
        PreferenceManager.getDefaultSharedPreferences(getApplication())
                .edit()
                .remove(USER_ID)
                .apply();
    }

    public LiveData<UserWithAddressRelation> isLogged(){
        Optional<String> id = Optional.ofNullable(
                PreferenceManager.getDefaultSharedPreferences(getApplication())
            .getString(USER_ID, null));

        if (!id.isPresent()){
            return new MutableLiveData<>(null);
        }

        return usersRepository.loadUserWithAddress(id.get());
    }






}
