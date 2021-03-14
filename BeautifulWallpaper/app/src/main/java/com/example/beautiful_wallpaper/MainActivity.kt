package com.example.beautiful_wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.beautiful_wallpaper.api.RetrofitInstance
import com.example.beautiful_wallpaper.model.MyData
import com.example.beautiful_wallpaper.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var textView: TextView

    //https://www.flickr.com/services/rest/?method=flickr.photos.getPopular&
    // api_key=d0b35bb8f5b40cf47de1b2fef586c1a4&user_id=192231193%40N06&format=json&nojsoncallback=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_hello)

//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getData()
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Responseeeeeeeeeee", response.body()?.photos?.page.toString())
////                Log.d("Response", response.body()?.id.toString())
////                Log.d("Response", response.body()?.title!!)
////                Log.d("Response", response.body()?.body!!)
//                textView.text = response.body().toString()
//
//            } else {
//                Log.d("Response", response.errorBody().toString())
//                textView.text = response.code().toString()
//            }
//
//        })

        callAPI()
    }

    private fun callAPI() {
        RetrofitInstance.api.getData2(
            "flickr.photos.getPopular",
            "d0b35bb8f5b40cf47de1b2fef586c1a4",
            "192231193%40N06", "json", 1
        )
            .enqueue(object : Callback<MyData?> {
                override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                    val myData: MyData? = response.body()
                    if (myData != null) {
                        textView.text = myData.toString()
                    }
                }

                override fun onFailure(call: Call<MyData?>, t: Throwable) {
                    textView.text = "lỗi"
                }
            })
    }


}