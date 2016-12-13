package com.example.vjimbei.rxjava2sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by vjimbei on 12/7/16.
 */

public class SingleActivity extends AppCompatActivity {
  @BindView(R.id.tv_output)
  TextView tvOutput;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);
    ButterKnife.bind(this);
  }

  public void onTestClick(View view) {
    Single.just("Test")
      .subscribe(getSingleObserver());
  }

  private SingleObserver<String> getSingleObserver() {

    return new SingleObserver<String>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onSuccess(String value) {
        tvOutput.append(" onNext : value : " + value);
        tvOutput.append("\n");
      }

      @Override
      public void onError(Throwable e) {
        tvOutput.append(" onError : " + e.getMessage());
        tvOutput.append("\n");
      }
    };
  }
}
