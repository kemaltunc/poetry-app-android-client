package com.tunc.androidpoetryapp.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tunc.androidpoetryapp.data.exception.ApiErrorHandle
import com.tunc.androidpoetryapp.data.exception.ErrorModel
import com.tunc.androidpoetryapp.util.SingleLiveEvent
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    val showMessage = SingleLiveEvent<String>()
    val requestEnd = SingleLiveEvent<Boolean>()

    private val apiErrorHandle = ApiErrorHandle()
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    private val scope = CoroutineScope(coroutineContext)

    fun <T> execute(
        call: suspend () -> T,
        result: (result: T) -> Unit = {},
        error: (error: ErrorModel) -> Unit = {}
    ) {
        scope.launch {
            withContext(Dispatchers.Main) {
                try {
                    val response = call.invoke()
                    result(response)
                    requestEnd.value = true

                } catch (e: HttpException) {
                    val errorModel = apiErrorHandle.traceErrorException(e)
                    error(errorModel)
                    showMessage.postValue(errorModel.message)
                    Log.d("ApiError", errorModel.message.toString())
                } catch (e: Throwable) {
                    val errorModel = apiErrorHandle.traceErrorException(e)
                    error(errorModel)
                    showMessage.postValue(errorModel.message)
                    Log.d("ApiError", errorModel.message.toString())
                }
            }
        }
    }

    fun cancelRequest() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancelChildren()
        cancelRequest()
    }

}