package com.example.vjimbei.rxjava2sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by vjimbei on 12/14/16.
 */

public class FlowableActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);
    ButterKnife.bind(this);
  }

  public void onTestClick(View view) {
    PublishSubject<Integer> source = PublishSubject.create();

    source
      .observeOn(Schedulers.computation())
      .subscribe(v -> compute(v), Throwable::printStackTrace);

    for (int i = 0; i < 1000000; i++) {
      source.onNext(i);
    }

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void compute(Integer v) {
    Log.i(this.getClass().getSimpleName(), String.valueOf(v));
  }


}
