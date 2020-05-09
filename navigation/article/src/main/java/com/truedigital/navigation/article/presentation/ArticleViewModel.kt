package com.truedigital.navigation.article.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pretest.civilwar.extension.addTo
import com.truedigital.navigation.article.domain.model.ArticleModel
import com.truedigital.navigation.article.domain.usecase.GetArticleListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ArticleViewModel(
    private val getArticleListUseCase: GetArticleListUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val articleListData = MutableLiveData<List<ArticleModel>>()
    private val showLoading = MutableLiveData<Unit>()
    private val hideLoading = MutableLiveData<Unit>()

    fun onShowArticleList() = articleListData
    fun onShowLoading() = showLoading
    fun onHideLoading() = hideLoading

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getArticleList() {
        getArticleListUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                showLoading.value = Unit
            }
            .doFinally {
                hideLoading.value = Unit
            }
            .subscribe({ list ->
                articleListData.value = list
            }, {})
            .addTo(compositeDisposable)
    }
}