package com.srikanth.dynamicfonts;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.srikanth.dynamicfont.Callback;
import com.srikanth.dynamicfont.FontConfig;

public class MainActivity extends AppCompatActivity {

    private TextView sampleText;
    private String fonturl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleText = (TextView) findViewById(R.id.sample_text);
        fonturl = "http://themes.googleusercontent.com/static/fonts/anonymouspro/v3/Zhfjj_gat3waL4JSju74E-V_5zh5b-_HiooIRUBwn1A.ttf";
        FontConfig.with(this).loadFont(fonturl, new Callback<Typeface>() {
            @Override
            public void send(Typeface typeface) {
                sampleText.setTypeface(typeface);
            }
        });

    }
}
