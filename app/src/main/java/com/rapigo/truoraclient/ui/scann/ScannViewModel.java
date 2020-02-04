package com.rapigo.truoraclient.ui.scann;

import com.rapigo.truoraclient.models.Domain;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScannViewModel extends ViewModel {
    private MutableLiveData<Domain> domain;

    public LiveData<Domain> getDomain(){
        if(domain==null){
            domain =  new MutableLiveData<Domain>();
        }
        return domain;
    }

    public void setDomain(Domain d){
        domain.postValue(d);
    }
}
