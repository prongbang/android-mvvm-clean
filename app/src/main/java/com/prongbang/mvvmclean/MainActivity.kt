package com.prongbang.mvvmclean

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.prongbang.mvvmclean.feature.feed.presentation.FeedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

	private val feedViewModel: FeedViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		getFeed()
	}

	private fun getFeed() {
		feedViewModel.apply {
			getFeedList()
			feedDataSuccess.observe(this@MainActivity, Observer {
				Timber.i(Gson().toJson(it))
			})
			feedDataError.observe(this@MainActivity, Observer {
				Toast.makeText(this@MainActivity, "Is Error", Toast.LENGTH_SHORT)
						.show()
			})
		}

	}
}
