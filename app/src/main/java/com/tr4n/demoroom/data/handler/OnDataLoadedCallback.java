package com.tr4n.demoroom.data.handler;

public interface OnDataLoadedCallback<Data> {
    void onSuccess(Data data);
    void onFailure(Exception e);
}
