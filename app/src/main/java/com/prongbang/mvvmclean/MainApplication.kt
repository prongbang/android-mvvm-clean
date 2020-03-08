package com.prongbang.mvvmclean

import android.app.Application
import com.prongbang.mvvmclean.di.contributorModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication : Application() {

	override fun onCreate() {
		super.onCreate()

		Timber.plant(Timber.DebugTree())

		startKoin {
			androidContext(this@MainApplication)
			modules(contributorModule)
			androidLogger()
		}
	}

}