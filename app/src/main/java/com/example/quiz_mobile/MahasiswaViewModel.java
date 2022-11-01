package com.example.quiz_mobile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MahasiswaViewModel extends ViewModel {
    private MutableLiveData<String> name;
    private MutableLiveData<String> nim;

    public MutableLiveData<String> getName() {
        if(name == null){
            name = new MutableLiveData<>();
        }
        return name;
    }
    public MutableLiveData<String> getNim() {
        if(nim == null){
            nim = new MutableLiveData<>();
        }
        return nim;
    }

    public void setName(String name) {
        this.name.postValue(name);
    }
    public void setNim(String nim) {
        this.nim.postValue(nim);
    }
}
