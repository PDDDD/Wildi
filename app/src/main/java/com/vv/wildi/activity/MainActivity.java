package com.vv.wildi.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.vv.wildi.R;
import com.vv.wildi.fragment.HomeFragment;
import com.vv.wildi.fragment.LadderFragment;
import com.vv.wildi.fragment.MallFragment;
import com.vv.wildi.fragment.MyFragment;
import com.vv.wildi.fragment.SocialFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private HomeFragment homeFragment;
    private LadderFragment ladderFragment;
    private MallFragment mallFragment;
    private SocialFragment socialFragment;
    private MyFragment myFragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.rg_main_tab)
    RadioGroup radioGroup;
    @BindView(R.id.tv_title)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_main_content, homeFragment).commit();
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        if (ladderFragment == null) {
            ladderFragment = new LadderFragment();
        }
        if (mallFragment == null) {
            mallFragment = new MallFragment();
        }
        if (socialFragment == null) {
            socialFragment = new SocialFragment();
        }
        if (myFragment == null) {
            myFragment = new MyFragment();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.rb_home:
                fragmentTransaction.replace(R.id.fl_main_content, homeFragment);
                textView.setText("首页");
                break;
            case R.id.rb_social:
                fragmentTransaction.replace(R.id.fl_main_content, socialFragment);
                textView.setText("社交");
                break;
            case R.id.rb_ladder:
                fragmentTransaction.replace(R.id.fl_main_content, ladderFragment);
                textView.setText("天梯");
                break;
            case R.id.rb_mall:
                fragmentTransaction.replace(R.id.fl_main_content, mallFragment);
                textView.setText("商城");
                break;
            case R.id.rb_my:
                fragmentTransaction.replace(R.id.fl_main_content, myFragment);
                textView.setText("我的");
                break;
        }
        fragmentTransaction.commit();
    }
}
