package com.example.vjimbei.rxjava2sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * Created by vjimbei on 12/7/16.
 */

public class NullsActivity extends AppCompatActivity {
  @BindView(R.id.tv_output)
  TextView tvOutput;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);
    ButterKnife.bind(this);
  }

  public void onTestClick(View view) {
    Observable.fromCallable(() -> null)
      .subscribe(this::setOutputText, this::setOutputThrowable);
  }

  private void setOutputText(Object text) {
    tvOutput.append(text == null ? "null" : text.toString());
    tvOutput.append("\n");
  }

  private void setOutputThrowable(Throwable throwable) {
    tvOutput.setText(throwable.getLocalizedMessage());
    tvOutput.append("\n");
  }
}
