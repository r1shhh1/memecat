package com.codewithharry.memecat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun loadMeme(){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        //Request a string response from the prvided URL.
       val jsonObjectRequest = JsonObjectRequest(
           Request.Method.GET, url, null,
           { response ->
               val url1 = response.getString("url")
               Glide.with(this).load(url1).into(memeImageView)
           },
           {
               Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
           })

        queue.add(jsonObjectRequest)

    }



    fun nextMeme(view: View) {

    }
    fun shareMeme(view: View) {

    }
}