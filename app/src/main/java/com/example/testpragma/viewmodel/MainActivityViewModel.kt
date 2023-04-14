package com.example.testpragma.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testpragma.model.Cat
import com.example.testpragma.model.Image
import com.example.testpragma.repository.main.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    private val _listCats = MutableLiveData<ArrayList<Cat>>()
    val listCats: LiveData<ArrayList<Cat>> = _listCats

    private val _image = MutableLiveData<Image>()
    val image: LiveData<Image> = _image

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getCats() {
        mainActivityRepository.getCats({
            _listCats.postValue(it)
        }, {
            _error.postValue(it)
        })
    }

    fun getImageCat(imageId: String?) {
        mainActivityRepository.getImageCat(imageId, {
            _image.postValue(it)
        }, {
            _error.postValue(it)
        })
    }
}