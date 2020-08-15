package com.aaronxie.messaging.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.aaronxie.messaging.bean.User;
import com.aaronxie.messaging.model.IUserModel;
import com.aaronxie.messaging.model.UserModelImpl;

import java.util.List;

public class ConversationListViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<List<User>> userLiveData = new MutableLiveData<>();

    public void setUserLiveData() {
        new UserModelImpl().onLoadUserData(new IUserModel() {
            @Override
            public void getUserData(List<User> users) {
                userLiveData.setValue(users);
            }
        });
    }

    public MutableLiveData<List<User>> getUserLiveData() {
        return userLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
