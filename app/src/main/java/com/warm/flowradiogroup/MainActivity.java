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
import com.warm.flowlayout.FlowRadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FlowRadioGroup radio;
    private FlowLayout flow;
    private Button bt_add, bt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio = (FlowRadioGroup) findViewById(R.id.radio);
        flow = (FlowLayout) findViewById(R.id.flow);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        String[] tags = "一个人的一生,应该是这,样度过的,当他回首往事的时候,他不会,因为虚度年华,而悔恨,也不会因为碌碌无为,而羞耻,《钢铁是怎样炼成的》".split(",");
        for (int i = 0; i < tags.length; i++) {
            radio.addView(buildRadioButton(tags[i]));
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

        radio.addView(buildRadioButton("《钢铁是怎样炼成的》"));
        flow.addView(buildButton("保尔·柯察金"));
    }

    private RadioButton buildRadioButton(String tag) {
        RadioButton rb = new RadioButton(this);
        rb.setBackgroundResource(R.drawable.bg_profit_rg);
        rb.setButtonDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));
        rb.setTextSize(14);
        rb.setGravity(Gravity.CENTER);
        rb.setText(tag);
        rb.setTextColor(ContextCompat.getColorStateList(this, R.color.text_profit));
        rb.setPadding(16,8,16,8);
//        rb.setLayoutParams(new FlowRadioGroup.LayoutParams(DisplayUtil.dp2px(this, 56), DisplayUtil.dp2px(this, 24)));
        return rb;
    }

    private Button buildButton(String tag) {
        Button rb = new Button(this);
        rb.setTextSize(14);
        rb.setText(tag);
        rb.setTextColor(ContextCompat.getColorStateList(this, R.color.text_profit));
        return rb;
    }


    private void delete() {
        if (radio.getChildCount() != 0) {
            radio.removeViewAt(radio.getChildCount() - 1);
        }
        if (flow.getChildCount() != 0) {
            flow.removeViewAt(flow.getChildCount() - 1);
        }
    }
}
