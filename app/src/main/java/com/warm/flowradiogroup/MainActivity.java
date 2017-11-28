package com.warm.flowradiogroup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.warm.library.flow.FlowRadioGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FlowRadioGroup rg_money;
    private RadioGroup radio;
    private Button bt_add, bt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_money = (FlowRadioGroup) findViewById(R.id.rg_money);
        radio = (RadioGroup) findViewById(R.id.radio);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        List<Integer> moneys = new ArrayList<>();
        moneys.add(100);
        moneys.add(200);
        moneys.add(300);
        moneys.add(400);
        moneys.add(500);
        moneys.add(600);
        moneys.add(700);

        for (int i = 0; i < moneys.size(); i++) {
          rg_money.addView(buildButton(moneys.get(i)));

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
        rg_money.addView(buildButton(100));
        radio.addView(buildButton(100));
    }

    private RadioButton buildButton(int money) {
        RadioButton rb = new RadioButton(this);
        rb.setBackgroundResource(R.drawable.bg_profit_rg);
        rb.setButtonDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));
        rb.setTextSize(18);
        rb.setGravity(Gravity.CENTER);
        rb.setText(String.format(Locale.CHINA, "%d元", money));
        rb.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        rb.setLayoutParams(new FlowRadioGroup.LayoutParams(DisplayUtil.dp2px(this, 56), DisplayUtil.dp2px(this, 24)));
        return rb;
    }

    private void delete() {
        if (rg_money.getChildCount() != 0)
            rg_money.removeViewAt(rg_money.getChildCount() - 1);
        if (radio.getChildCount() != 0) {
            radio.removeViewAt(radio.getChildCount() - 1);
        }
    }
}
