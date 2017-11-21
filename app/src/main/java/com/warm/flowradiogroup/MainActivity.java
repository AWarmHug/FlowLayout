package com.warm.flowradiogroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.warm.library.FlowRadioGroup;

public class MainActivity extends AppCompatActivity {
    private FlowRadioGroup rg_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_money = (FlowRadioGroup) findViewById(R.id.rg_money);
//        List<Integer> moneys = new ArrayList<>();
//        moneys.add(100);
//        moneys.add(200);
//        moneys.add(300);
//        moneys.add(400);
//        moneys.add(500);
//        moneys.add(600);
//        moneys.add(700);
//
//        for (int i = 0; i < moneys.size(); i++) {
//            RadioButton rb = new RadioButton(this);
//            rb.setId(moneys.get(i));
//            rb.setBackgroundResource(R.drawable.bg_profit_rg);
//            rb.setButtonDrawable(new ColorDrawable(ContextCompat.getColor(this, android.R.color.transparent)));
//            rb.setPadding(DisplayUtil.dp2px(this, 24), DisplayUtil.dp2px(this, 12), DisplayUtil.dp2px(this, 24), DisplayUtil.dp2px(this, 12));
//            rb.setTextSize(18);
//            rb.setGravity(Gravity.CENTER);
//            rb.setText(String.format(Locale.CHINA, "%d元", moneys.get(i)));
//            rb.setTextColor(ContextCompat.getColorStateList(this, R.color.text_profit));
//            if (i == 0) {
//                rb.setChecked(true);
//            }
//            rb.setLayoutParams(new RadioGroup.LayoutParams(DisplayUtil.dp2px(this,56),DisplayUtil.dp2px(this,24)));
//            rg_money.addView(rb);
//
//        }
    }
}
