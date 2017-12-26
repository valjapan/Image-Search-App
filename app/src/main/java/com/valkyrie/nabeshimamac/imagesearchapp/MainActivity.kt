package com.valkyrie.nabeshimamac.imagesearchapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var findView: ImageView
    private lateinit var findEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findView = findViewById(R.id.image_view)
        findEditText = findViewById(R.id.search_edit_text)
        sendButton = findViewById(R.id.button)

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://tranquil-tundra-51955.herokuapp.com")
                .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        client = retrofit.create(Client::class.java)

        sendButton.setOnClickListener {
            val editString: String = findEditText.text.toString()

            if (editString.isBlank()) {
                Toast.makeText(this, "空白です。", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 検索で条件
            if (editString == "apple") {
                apple()
                Log.d("DEBUGGG", "Apple")

            } else if (editString == "melon") {
                melon()
            } else {
                Toast.makeText(this, "この単語には対応していません。", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun apple() {
        Log.d("DEBUGGG", "gettttt")

        client.appleImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ item ->
                    Glide.with(this).load(item.data).into(findView)
                    Log.d("DEBUGGG", "apple")
                }, { error ->
                    Log.e("Error", error.message)
                })
    }

    private fun melon() {
        client.orangeImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ item ->
                    Glide.with(this).load(item.data).into(findView)
                }, {
                })
    }
}
