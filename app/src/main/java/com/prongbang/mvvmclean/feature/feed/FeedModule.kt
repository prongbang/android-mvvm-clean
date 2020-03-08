package com.prongbang.mvvmclean.feature.feed

import com.prongbang.mvvmclean.feature.feed.data.DefaultFeedRepository
import com.prongbang.mvvmclean.feature.feed.data.FeedRepository
import com.prongbang.mvvmclean.feature.feed.domain.DefaultGetFeedListUseCase
import com.prongbang.mvvmclean.feature.feed.domain.GetFeedListUseCase
import com.prongbang.mvvmclean.feature.feed.presentation.FeedViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {
	factory<FeedRepository> { DefaultFeedRepository() }
	factory<GetFeedListUseCase> { DefaultGetFeedListUseCase(get()) }
	viewModel<FeedViewModel>()
}