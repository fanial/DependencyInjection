package com.fal.dependencyinjection.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fal.dependencyinjection.model.DataProductItem
import com.fal.dependencyinjection.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(val api : RestfulApi) : ViewModel() {
    lateinit var liveDataProduk: MutableLiveData<List<DataProductItem>>

    init {
        liveDataProduk = MutableLiveData()
    }
    fun getliveData() : MutableLiveData<List<DataProductItem>> {
        return  liveDataProduk
    }

    fun callApiProduct(){
        api.getProducts()
            .enqueue(object : Callback<List<DataProductItem>>{
                override fun onResponse(
                    call: Call<List<DataProductItem>>,
                    response: Response<List<DataProductItem>>,
                ) {
                    if (response.isSuccessful){
                        liveDataProduk.postValue(response.body()!!)
                    }else{
                        liveDataProduk.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DataProductItem>>, t: Throwable) {
                    liveDataProduk.postValue(null)
                }

            })
    }
}