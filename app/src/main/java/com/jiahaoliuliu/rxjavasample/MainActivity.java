package com.jiahaoliuliu.rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaExample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        createObservable();
        createSingles();
    }

    private void createObservable() {
        Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.v(TAG, "onSubscribe: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.v(TAG, "onNext: " + value + " " + Thread.currentThread().getName());
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.v(TAG, "onComplete: All Done! " + Thread.currentThread().getName());
                    }
            }
        );
    }

    private void createSingles() {
        Single.just("Hello team")
            .subscribe(new SingleObserver<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.v(TAG, "OnSubscribe: " + d);
                }

                @Override
                public void onSuccess(String s) {
                    Log.v(TAG, "On success: " + s);
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, "On error: ", e);
                }
            });
    }

}
