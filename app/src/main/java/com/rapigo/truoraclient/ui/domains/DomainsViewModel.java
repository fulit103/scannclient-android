package com.rapigo.truoraclient.ui.domains;

import com.rapigo.truoraclient.client.CallbackHttp;
import com.rapigo.truoraclient.client.TruoraService;
import com.rapigo.truoraclient.models.Domain;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DomainsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Domain>> domains;

    public DomainsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Domain>> getDomains(){
        if( domains==null ){
            domains = new MutableLiveData<List<Domain>>();
            loadDomains();
        }
        return domains;
    }

    private void loadDomains(){
        TruoraService client = new TruoraService(null);
        client.getDomains(new CallbackHttp<List<Domain>>() {
            @Override
            public void success(List<Domain> d) {
                domains.setValue(d);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}