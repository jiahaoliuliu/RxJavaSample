package com.jiahaoliuliu.rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaExample";

    private Observable<Integer> integerObservable;
    private Observable<String> stringObservable;
    private Observable<Integer> rangeObservable;
    private Observable<Long> intervalObservable;
    private Observable<String> emptyObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create observable and observer for integer
//        createIntObservable();
//        createIntObserver();

        // Create observable and observer for string
//        createStringObservable();
//        createStringObserver();

        // Range observable/observer. It emits numbers from a certain
        // range
//        createRangeObservable();
//        createRangeObserver();

        // Interval observable/observer. It periodically (time)
        // increases the number
        createIntervalObservable();
        createIntervalObserver();

        // Empty observable/observer. Does not do anything
//        createEmptyObservable();
//        createEmptyObserver();
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

    private void createStringObservable() {
        stringObservable = Observable.just("This is a string");
    }

    private void createStringObserver() {
        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "OnSubscribe: " + d);
            }

            @Override
            public void onNext(String string) {
                Log.v(TAG, "OnNext: " + string);
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

        stringObservable.subscribe(stringObserver);
    }

    private void createRangeObservable() {
        rangeObservable = Observable.range(0, 5);
    }

    private void createRangeObserver() {
        Observer<Integer> rangeObserver = new Observer<Integer>() {

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

        rangeObservable.subscribe(rangeObserver);
    }

    private void createIntervalObservable() {
        intervalObservable = Observable.interval(500, TimeUnit.MILLISECONDS);
    }

    private void createIntervalObserver() {
        Observer<Long> intervalObserver = new Observer<Long>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "OnSubscribe: " + d);
            }

            @Override
            public void onNext(Long value) {
                Log.v(TAG, "OnNext: " + value);
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

        intervalObservable.subscribe(intervalObserver);
    }

    private void createEmptyObservable() {
        emptyObservable = Observable.empty();
    }

    private void createEmptyObserver() {
        Observer<String> emptyObserver = new Observer<String> () {
            @Override
            public void onSubscribe(Disposable d) {
                Log.v(TAG, "OnSubscribe: " + d);
            }

            @Override
            public void onNext(String string) {
                Log.v(TAG, "OnNext: " + string);
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

        emptyObservable.subscribe(emptyObserver);
    }
}
