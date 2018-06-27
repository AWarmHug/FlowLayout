package com.warm.flowradiogroup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.warm.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FlowLayout radio;
    private Button bt_add, bt_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio = (FlowLayout) findViewById(R.id.radio);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        List<String> tags = new ArrayList<>();
        tags.add("你好啊");
        tags.add("我不好");
        tags.add("你很好，就是好啊啊啊");
        tags.add("我说不好就是不好");
        tags.add("说你好，你就好");
        tags.add("不好");
        tags.add("好");
        tags.add("好个屁");

        for (int i = 0; i < tags.size(); i++) {
            radio.addView(buildButton(tags.get(i)));
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_add) {
            add();
        } else {
            delete();
        }
    }

    private void add() {
        radio.addView(buildButton("不好不好不好"));
    }

    private RadioButton buildButton(String tag) {
        RadioButton rb = new RadioButton(this);
        rb.setBackgroundResource(R.drawable.bg_profit_rg);
        rb.setButtonDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));
        rb.setTextSize(14);
        rb.setGravity(Gravity.CENTER);
        rb.setText( tag);
        rb.setTextColor(ContextCompat.getColorStateList(this, R.color.text_profit));
//        rb.setLayoutParams(new FlowRadioGroup.LayoutParams(DisplayUtil.dp2px(this, 56), DisplayUtil.dp2px(this, 24)));
        return rb;
    }

    private void delete() {
        if (radio.getChildCount() != 0) {
            radio.removeViewAt(radio.getChildCount() - 1);
        }
    }
}
