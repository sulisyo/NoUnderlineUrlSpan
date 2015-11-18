package com.ramodal.gembong.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.ramodal.gembong.linkspan.LinkSpan;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        TextView textView = (TextView) findViewById(R.id.text);
        SpannableStringBuilder s = (SpannableStringBuilder) Html.fromHtml("ini link ke www.buzzbuddies.com");
        textView.setText(LinkSpan.setUrlLinkNoUnderline(s));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
