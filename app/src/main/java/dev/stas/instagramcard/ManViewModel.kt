package dev.stas.instagramcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManViewModel: ViewModel() {

    private val _isFollowed = MutableLiveData<Boolean>()
    val isFollowed: LiveData<Boolean>
        get() = _isFollowed

    fun changeFollowingStatus(){
        val wasFollowing = _isFollowed.value ?: false
        _isFollowed.value = !wasFollowing
    }
}