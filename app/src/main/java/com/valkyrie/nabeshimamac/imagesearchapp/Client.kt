package com.valkyrie.nabeshimamac.imagesearchapp

import retrofit2.http.GET
import rx.Observable

/**
 * Created by NabeshimaMAC on 2017/12/26.
 */
interface Client {

    @GET("/photo/apple")
    fun appleImage(): Observable<RemoteImage>

    @GET("/photo/melon")
    fun melonImage(): Observable<RemoteImage>

    @GET("/photo/orange")
    fun orangeImage(): Observable<RemoteImage>

    @GET("/photo/lit")
    fun litImage(): Observable<RemoteImage>
}