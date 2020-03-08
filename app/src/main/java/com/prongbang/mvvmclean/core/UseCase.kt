package com.prongbang.mvvmclean.core

abstract class UseCase<P, R> {
	abstract suspend fun execute(parameters: P): R
}