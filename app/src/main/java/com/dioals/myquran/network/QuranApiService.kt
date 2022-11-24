package com.dioals.myquran.network

import com.dioals.myquran.model.Chapters
import com.dioals.myquran.model.Response
import com.dioals.myquran.model.Verses
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Dio Als on 09/04/2022
 */

private const val BASE_URL =
    "https://api.quran.com/api/v3/"
val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

enum class ApiStatus { LOADING, ERROR, DONE }

interface QuranApiService {
    @GET("chapters")
    suspend fun getSurahList(): Chapters

    @GET("chapters/{number}/verses")
    suspend fun getSurah(@Path("number")number: Int,@Query("page") page:Int):Verses

    @GET("juz/{number}")
    suspend fun getJuz(@Path("number") number: Int):Response
}

object QuranApi {
    val retrofitService: QuranApiService by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
        retrofit.create(QuranApiService::class.java)
    }
}