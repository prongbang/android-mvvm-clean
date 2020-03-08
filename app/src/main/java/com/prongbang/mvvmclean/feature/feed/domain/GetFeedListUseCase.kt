package com.prongbang.mvvmclean.feature.feed.domain

import com.prongbang.mvvmclean.core.Results
import com.prongbang.mvvmclean.core.UseCase
import com.prongbang.mvvmclean.feature.feed.data.FeedRepository

abstract class GetFeedListUseCase : UseCase<Unit, Results<List<Feed>>>()

class DefaultGetFeedListUseCase(
		private val feedRepository: FeedRepository
) : GetFeedListUseCase() {

	override suspend fun execute(parameters: Unit): Results<List<Feed>> {
		return feedRepository.getFeedList()
	}

}