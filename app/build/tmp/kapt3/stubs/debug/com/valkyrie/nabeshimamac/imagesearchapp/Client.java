package com.valkyrie.nabeshimamac.imagesearchapp;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/valkyrie/nabeshimamac/imagesearchapp/Client;", "", "appleImage", "Lrx/Observable;", "Lcom/valkyrie/nabeshimamac/imagesearchapp/RemoteImage;", "orangeImage", "app_debug"})
public abstract interface Client {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/photo/apple")
    public abstract rx.Observable<com.valkyrie.nabeshimamac.imagesearchapp.RemoteImage> appleImage();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/photo/melon")
    public abstract rx.Observable<com.valkyrie.nabeshimamac.imagesearchapp.RemoteImage> orangeImage();
}