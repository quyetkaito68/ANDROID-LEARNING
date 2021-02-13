package com.example.dailoanpro

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.jsoup.Jsoup
import org.w3c.dom.Document
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var txt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // ReadContentURL().execute("https://dailoan.pro/ket-qua-so-hoa-don-dai-loan-thang-11-12-nam-2020/") // doc html tu link
       // LoadImage().execute("https://icdn.dantri.com.vn/thumb_w/640/2017/1-1510967806416.jpg") //doc anh tu link

       //webview
       val myWebView: WebView = findViewById(R.id.webview)
      myWebView.webViewClient
        myWebView.loadUrl("https://dailoan.pro/ket-qua-so-hoa-don-dai-loan-thang-11-12-nam-2020/")
        txt = findViewById(R.id.textView)
        doit().execute()


    }
    @Suppress("DEPRECATION")
    public inner class doit:  AsyncTask<Void, Void, Void>(){
        var words: String = ""
        override fun doInBackground(vararg p0: Void?): Void? {
            try {


                val doc: org.jsoup.nodes.Document? = Jsoup.connect("https://dailoan.pro/ket-qua-so-hoa-don-dai-loan-thang-11-12-nam-2020/").get()
                words = doc.toString()


            }catch (e: Exception){
                Log.d("AAA",e.toString())
            }
                return null;
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            txt.setText(words)
        }

    }

//    @Suppress("DEPRECATION")
//    inner class ReadContentURL : AsyncTask<String, Void, String>() {
//        override fun doInBackground(vararg p0: String?): String {
//            var content: StringBuilder  = StringBuilder()
//            val url: URL = URL(p0[0])
//            var urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
//            val inputStream: InputStream = urlConnection.inputStream
//            val inputStreamReader: InputStreamReader = InputStreamReader(inputStream)
//            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
//            var line:String ?= ""
//            try {
//                do{
//                    line = bufferedReader.readLine()
//                    if (line!=null){
//                        content.append(line)
//                    }
//                    bufferedReader.close()
//                }while (line!=null)
//            }catch (e: Exception){
//                Log.d("AAA",e.toString())
//            }
//            return content.toString()
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            Toast.makeText(this@MainActivity,result,Toast.LENGTH_LONG).show()
//            val txt:TextView = findViewById(R.id.textView)
//            txt.setText(result)
//        }
//    }
//
//    inner class LoadImage: AsyncTask<String, Void, Bitmap>(){
//        override fun doInBackground(vararg p0: String?): Bitmap {
//            val url = URL(p0[0])
//            val inputStream = url.openConnection().getInputStream()
//            val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
//            return  bitmap
//        }
//
//        override fun onPostExecute(result: Bitmap?) {
//            super.onPostExecute(result)
//            val img: ImageView = findViewById(R.id.imageView)
//            img.setImageBitmap(result)
//        }
//
//    }
}