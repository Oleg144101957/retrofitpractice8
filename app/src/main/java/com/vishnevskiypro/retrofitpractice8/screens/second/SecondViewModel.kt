package com.vishnevskiypro.retrofitpractice8.screens.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.retrofitpractice8.data.repository.Repository
import com.vishnevskiypro.retrofitpractice8.models.beznal.Beznal
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {

    val moneyListBeznal: MutableLiveData<Response<Beznal>> = MutableLiveData()
    val repo = Repository()

    fun getBeznalFromRepo(){
        viewModelScope.launch{
            moneyListBeznal.value = repo.getBeznalFromRetro()
        }

    }


}
