package com.prongbang.mvvmclean.core

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Results<out R> {
	data class Success<out T>(val data: T) : Results<T>()
	data class Error(val exception: Throwable) : Results<Nothing>()
	object Loading : Results<Nothing>()
	object Empty : Results<Nothing>()
	object Network : Results<Nothing>()
	object Unauthorized : Results<Nothing>()
	object Timeout : Results<Nothing>()
}

val Results<*>.succeeded
	get() = this is Results.Success && data != null