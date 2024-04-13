package dev.stas.instagramcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500){
            add(
                InstagramModel(
                    id = it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models: LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(model: InstagramModel) {
        val oldCollection = _models.value ?: return
        val newCollection = oldCollection.map { item ->
            if (item.id == model.id) {
                item.copy(isFollowed = !item.isFollowed)
            } else {
                item
            }
        }
        _models.value = newCollection
    }

    fun delete(model: InstagramModel){
        val oldCollection = _models.value?.toMutableList() ?: mutableListOf()
        oldCollection.remove(model)
        _models.value = oldCollection
    }
}