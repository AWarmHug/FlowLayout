package com.warm.flowradiogroup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.warm.library.flow.FlowLayout;
import com.warm.library.flow.FlowRadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FlowRadioGroup rg_money;
    private com.warm.library.FlowRadioGroup radio;
    private Button bt_add, bt_delete;
    private FlowLayout flow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flow= (FlowLayout) findViewById(R.id.flow);
        rg_money = (FlowRadioGroup) findViewById(R.id.rg_money);
        radio = (com.warm.library.FlowRadioGroup) findViewById(R.id.radio);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        List<String> tags = new ArrayList<>();
        tags.add("你好啊");
        tags.add("我不好");
        tags.add("你很好，就是好");
        tags.add("我说不好就是不好");
        tags.add("说你好，你就好");
        tags.add("不好");
        tags.add("好");
        tags.add("好个屁");

        for (int i = 0; i < tags.size(); i++) {
          rg_money.addView(buildButton(tags.get(i)));

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
        flow.addView(buildButton("好好好好"));
        rg_money.addView(buildButton("好个屁"));
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
        if (flow.getChildCount()!=0)
            flow.removeViewAt(flow.getChildCount()-1);
        if (rg_money.getChildCount() != 0)
            rg_money.removeViewAt(rg_money.getChildCount() - 1);
        if (radio.getChildCount() != 0) {
            radio.removeViewAt(radio.getChildCount() - 1);
        }
    }
}
