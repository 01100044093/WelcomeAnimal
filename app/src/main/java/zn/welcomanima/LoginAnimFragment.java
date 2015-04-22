package zn.welcomanima;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;


import zn.library.AnimalUtul;
import zn.library.DisplayUtil;
import zn.welcomanima.loginlayer.LoginFragment;
import zn.welcomanima.loginlayer.RegisterFragment;

/**
 * 登录层
 */
public class LoginAnimFragment extends FragmentActivity {

    RelativeLayout rl_parent;
    Fragment mLoginFragment, mRegisterFragment;
    ViewPager mViewPager;
    private TextView mLoginText, mRegisterText;
    private AnimatorSet mAnimatorSet;
    private float mLogoY;
    private ImageView iv_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_welcomanim_login);
        rl_parent = (RelativeLayout)findViewById(R.id.rl_parent);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_fragment);
        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        mLoginFragment = new LoginFragment();
        mRegisterFragment = new RegisterFragment();
        mLoginText = (TextView) findViewById(R.id.tv_Login);
        mRegisterText = (TextView)findViewById(R.id.tv_reg);
        mRegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
            }
        });
        mLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });
        mViewPager.setAdapter(new ContainerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    mLoginText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_triangle);
                    mRegisterText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    mLoginText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    mRegisterText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_triangle);
                }
            }
        });
        /**
         * rl_parent 出现的布局
         * iv_logo 变小的图片
         */
      new AnimalUtul(this,rl_parent,iv_logo);
    }

    public void playInAnim(){
        rl_parent.setVisibility(View.VISIBLE);

        AnimatorSet mAnimatorSet;
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(rl_parent,
                "y", DisplayUtil.getDisplayheightPixels(this), DisplayUtil.dip2px(this, 160));

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(anim3);
        mAnimatorSet.setDuration(1000);
        mAnimatorSet.start();
    }
    private void playLogoInAnim(){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv_logo, "scaleX", 1.0f, 0.5f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv_logo, "scaleY", 1.0f, 0.5f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv_logo, "y", mLogoY, DisplayUtil.dip2px(LoginAnimFragment.this, 15));

        if(mAnimatorSet != null && mAnimatorSet.isRunning()){
            mAnimatorSet.cancel();
            mAnimatorSet = null;
        }
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(anim1).with(anim2);
        mAnimatorSet.play(anim2).with(anim3);
        mAnimatorSet.setDuration(1000);
        mAnimatorSet.start();
    }
    public class ContainerAdapter extends FragmentPagerAdapter {

        public ContainerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mLoginFragment;
                case 1:
                    return mRegisterFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
