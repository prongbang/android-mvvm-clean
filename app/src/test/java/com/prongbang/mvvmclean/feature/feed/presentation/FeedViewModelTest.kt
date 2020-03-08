package com.prongbang.mvvmclean.feature.feed.presentation

import com.google.common.truth.Truth.assertThat
import com.prongbang.mvvmclean.core.Results
import com.prongbang.mvvmclean.core.livedata.observeOnce
import com.prongbang.mvvmclean.core.livedata.testObserver
import com.prongbang.mvvmclean.core.test.ViewModelTest
import com.prongbang.mvvmclean.feature.feed.domain.Feed
import com.prongbang.mvvmclean.feature.feed.domain.GetFeedListUseCase
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FeedViewModelTest : ViewModelTest() {

	@MockK
	private lateinit var getFeedListUseCase: GetFeedListUseCase

	private val feedViewModel by lazy { FeedViewModel(getFeedListUseCase) }

	@Test
	fun getFeedList_ShouldReturnFeedList_WhenGetFeedSuccess() = runBlocking {
		val feedListResult = Results.Success(listOf(
				Feed(id = 1, title = "Title 1", subtitle = "Subtitle 1")
		))
		coEvery { getFeedListUseCase.execute(Unit) } returns feedListResult

		feedViewModel.getFeedList()

		feedViewModel.feedDataSuccess.observeOnce {
			assertThat(Results.Success(it)).isEqualTo(feedListResult)
		}

		// OR
		val actual = feedViewModel.feedDataSuccess.testObserver().observedValues[0]
		assertThat(Results.Success(actual)).isEqualTo(feedListResult)
	}
}