package com.example.mod12apirest

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

class PunkVM : ViewModel() {
    val punkBeer : PunkBeer? = null
    val clientHttp = OkHttpClient()
    private val requestBeers = Request.Builder()
        .url("https://api.punkapi.com/v2/beers")
        .build()

    init {
        viewModelScope.launch{
            val response = clientHttp.newCall(requestBeers).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }
                override fun onResponse(call: Call, response: Response) {
                    //Logi crée un log d'information aevc un TAG
                    Log.i(TAG, "PunkVm: ${response.body?.string().toString()}",)
                    val responseJson : JSONArray = JSONArray(response.body?.string())
                    val beerAl = arrayListOf<PunkBeer>()
                    for (beer in 0 until responseJson.length()){
                        beerAl.add(
                            PunkBeer(
                                responseJson.getJSONObject(beer).getString("name"),
                                responseJson.getJSONObject(beer).getString("description"),
                                responseJson.getJSONObject(beer).getDouble("abv"),
                                responseJson.getJSONObject(beer).getString("tagline"),
                                0.0 /*responseJson.getJSONObject(beer).getDouble("ibu"),*/

                                )
                        )
                    }
                    Log.i(TAG, "PunkVM : Je bois pas ")
                }
            })
        }
    }
}