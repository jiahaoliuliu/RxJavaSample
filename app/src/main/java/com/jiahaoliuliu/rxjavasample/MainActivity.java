package com.jiahaoliuliu.rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaExample";

    private Observable<Integer> integerObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createIntObservable();
        createIntObserver();

    }

    private void createIntObservable() {
        integerObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);

                // Once the observable has emitted all the items in the sequence,
                // call on Complete
                e.onComplete();
            }
        });
    }

    private void createIntObserver() {
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "OnSubscribe: " + d);
            }

            @Override
            public void onNext(Integer integer) {
                Log.v(TAG, "OnNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.v(TAG, "OnError: " + e);
            }

            @Override
            public void onComplete() {
                Log.v(TAG, "OnComplete: ");
            }
        };

        // The observable subscribe to the observer
        integerObservable.subscribe(myObserver);
    }
}
