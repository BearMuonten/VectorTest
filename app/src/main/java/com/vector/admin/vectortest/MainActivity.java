package com.vector.admin.vectortest;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.database.Observable;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView image_view, image_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_view = (ImageView) findViewById(R.id.image_view);
//        image_view2= (ImageView) findViewById(R.id.image_view2);
        Drawable drawable = image_view.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

//        Drawable drawable2=image_view2.getDrawable();
//        if (drawable2 instanceof Animatable){
//            ((Animatable) drawable2).start();
//        }

//        testRxjava();
        getNetData();
    }

    private void testRxjava() {
        observable.subscribe(observer);

    }

    //被观察者
    io.reactivex.Observable observable = io.reactivex.Observable.create(new ObservableOnSubscribe() {
        @Override
        public void subscribe(ObservableEmitter e) throws Exception {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onNext(4);
            e.onComplete();
        }
    });

    //观察者
    Subscriber subscriber=new Subscriber() {
        @Override
        public void onSubscribe(Subscription s) {

        }

        @Override
        public void onNext(Object o) {

        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {

        }
    };



    //观察者
    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Integer value) {
            Log.e("value", value + "");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };


    private void getNetData() {
        OkHttpClient ohc = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = ohc.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response) {
//                    String s=response.cacheResponse().toString();
//                    {
//                        Log.e("value", s);
//                    }
                }
            }
        });
    }

    private void postNetData() {

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class MySerice extends JobService {
        @Override
        public boolean onStartJob(JobParameters jobParameters) {
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }


    private void upFile(){
        File file=new File(Environment.getExternalStorageDirectory(),"xf.mp4");
    }


}
