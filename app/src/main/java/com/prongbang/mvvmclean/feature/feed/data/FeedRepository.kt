package com.prongbang.mvvmclean.feature.feed.data

import com.prongbang.mvvmclean.core.Results
import com.prongbang.mvvmclean.feature.feed.domain.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface FeedRepository {
	suspend fun getFeedList(): Results<List<Feed>>
}

class DefaultFeedRepository : FeedRepository {

	override suspend fun getFeedList(): Results<List<Feed>> {
		return withContext(Dispatchers.IO) {
			Results.Success(listOf(
					Feed(id = 1, title = "Feed 1", subtitle = "Subtitle 1"),
					Feed(id = 2, title = "Feed 2", subtitle = "Subtitle 2")
			))
		}
	}

}