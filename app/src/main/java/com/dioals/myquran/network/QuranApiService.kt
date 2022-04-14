package com.dioals.myquran.network

import com.dioals.myquran.model.Response
import com.dioals.myquran.model.Surah
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dio Als on 09/04/2022
 */

private const val BASE_URL =
    "https://api.quran.sutanlab.id"
val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

enum class ApiStatus { LOADING, ERROR, DONE }

interface QuranApiService {
    @GET("surah")
    suspend fun getSurahList(): Response

    @GET("surah/{number}")
    suspend fun getSurah(@Path("number")number: Int):Response

    @GET("juz/{number}")
    suspend fun getJuz(@Path("number") number: Int):Response
}

object QuranApi {
    val retrofitService: QuranApiService by lazy {
        retrofit.create(QuranApiService::class.java)
    }
}