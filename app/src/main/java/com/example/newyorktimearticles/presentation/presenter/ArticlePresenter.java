package com.example.newyorktimearticles.presentation.presenter;

import com.example.newyorktimearticles.base.Executors;
import com.example.newyorktimearticles.base.IExecutors;
import com.example.newyorktimearticles.data.ServerException;
import com.example.newyorktimearticles.domain.GetArticleUseCase;
import com.example.newyorktimearticles.presentation.ui.IArticleView;

import java.net.UnknownHostException;

import io.reactivex.disposables.CompositeDisposable;

public class ArticlePresenter implements IArticlePresenter {

    private CompositeDisposable compositeDisposable;
    private IExecutors executors;
    private IArticleView view;
    private GetArticleUseCase getArticleUseCase;

    public ArticlePresenter(IArticleView view) {
        compositeDisposable = new CompositeDisposable();
        executors = new Executors();
        this.view = view;
        getArticleUseCase = new GetArticleUseCase();
    }

    @Override
    public void fetchArticles() {
        compositeDisposable.add(getArticleUseCase.execute(null)
                .observeOn(executors.getMainThread())
                .subscribeOn(executors.getIOThread())
                .doOnSubscribe(disposable ->
                        view.showProgress(true))
                .doOnSuccess(result ->
                        view.getArticles(result.getArticlesList()))
                .doFinally(() -> view.showProgress(false))
                .subscribe((result, throwable) -> {
                    if (throwable instanceof UnknownHostException) {
                        view.displayError(ServerException.UnKnownHost);
                    }
                }));
    }

    @Override
    public void onDestroy() {
        if (!compositeDisposable.isDisposed())
            compositeDisposable.dispose();
        if (view != null)
            view = null;
    }
}
