package com.rapigo.truoraclient.client;

public interface CallbackHttp<T> {

    public void success(T t);

    public void error(String error);

}
