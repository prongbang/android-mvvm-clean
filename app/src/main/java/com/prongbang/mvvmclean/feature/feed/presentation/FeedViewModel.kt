package com.prongbang.mvvmclean.feature.feed.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prongbang.mvvmclean.core.Results
import com.prongbang.mvvmclean.feature.feed.domain.Feed
import com.prongbang.mvvmclean.feature.feed.domain.GetFeedListUseCase
import kotlinx.coroutines.launch

class FeedViewModel(
		private val getFeedListUseCase: GetFeedListUseCase
) : ViewModel() {

	val feedDataSuccess = MutableLiveData<List<Feed>>()
	val feedDataError = MutableLiveData<Boolean>()

	fun getFeedList() {
		viewModelScope.launch {
			when (val result = getFeedListUseCase.execute(Unit)) {
				is Results.Success -> {
					feedDataSuccess.postValue(result.data)
				}
				else -> {
					feedDataError.postValue(true)
				}
			}
		}
	}

}