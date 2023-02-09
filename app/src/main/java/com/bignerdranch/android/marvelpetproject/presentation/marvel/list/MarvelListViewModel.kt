package com.bignerdranch.android.marvelpetproject.presentation.marvel.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.bignerdranch.android.marvelpetproject.domain.interactor.MarvelInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelListViewModel @Inject constructor(
    private val interactor: MarvelInteractor
) : ViewModel() {

    val heroesListLiveData = MutableLiveData<List<MarvelData>>()

    val resultErrorLiveData = MutableLiveData<String>()

    fun getHeroesList() {

        viewModelScope.launch() {
            try {
                val response = withContext(Dispatchers.IO) {
                    interactor.getMarvelList()
                }
                if (response.isSuccessful && response.body() != null) {
                    heroesListLiveData.value = response.body()
                } else {
                    resultErrorLiveData.value = response.errorBody().toString()
                }
            } catch (e: Throwable) {
                resultErrorLiveData.value = e.localizedMessage
            }
        }
    }
}