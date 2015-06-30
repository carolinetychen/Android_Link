package com.example.carolinechen.link;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.text.style.URLSpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;

public class MainActivity extends Activity {

    Pattern URL_pattern = Pattern.compile("((https?)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+))");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testing strings
        String str1 = "http://www.google.com";
        String str2 = "哈囉https://www.google.com一二三http://www.google.com巴茲";
        String str3 = "http://www.google.com\nhttps://www.google.com\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "哈囉https://www.google.com一二三http://www.google.com巴茲\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n"+
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n" +
                "1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n1.把他塗鴉牆翻個徹底\n";
        setURL_pattern(str3, R.id.link1);
    }

    public void setURL_pattern (String str, int id) {
        TextView text = (TextView) findViewById(id);

        Spannable spannable = new SpannableString(str);
        Matcher matcher = URL_pattern.matcher(str);

        while (matcher.find()) {
            URLSpan urlSpan = new URLSpan(matcher.group(1));
            spannable.setSpan(urlSpan, matcher.start(1), matcher.end(1),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        text.setText(spannable, TextView.BufferType.SPANNABLE);
        text.setMovementMethod(new ScrollingMovementMethod());
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

