package com.vishnevskiypro.retrofitpractice8.screens.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.retrofitpractice8.data.repository.Repository
import com.vishnevskiypro.retrofitpractice8.models.nal.Nalichka
import kotlinx.coroutines.launch
import retrofit2.Response

class FirstViewModel : ViewModel() {

    val moneyListNal: MutableLiveData<Response<Nalichka>> = MutableLiveData()
    val repo = Repository()

    fun getNalFromRepo(){
        viewModelScope.launch {
            moneyListNal.value = repo.getNalFromRetro()
        }
    }


}