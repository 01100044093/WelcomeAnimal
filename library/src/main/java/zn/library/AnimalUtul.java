package zn.library;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Administrator on 2015/4/16.
 */
public class AnimalUtul {
    private AnimatorSet mAnimatorSet;
    RelativeLayout rl_parent;
    private ImageView iv_logo;
    private float mLogoY;
    private Context context;
    private long starttime=1500;

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public AnimalUtul(Context context, RelativeLayout layout, ImageView logo) {
        iv_logo=logo;
        rl_parent=layout;
        this.context=context;
        iv_logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mLogoY == 0){
                    mLogoY = ViewHelper.getY(iv_logo);
                }
                playLogoInAnim();
            }
        },starttime);
        iv_logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                playInAnim();
            }
        }, starttime);

    }
    public void playInAnim(){
        rl_parent.setVisibility(View.VISIBLE);

        AnimatorSet mAnimatorSet;
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(rl_parent,
                "y", DisplayUtil.getDisplayheightPixels(context), DisplayUtil.dip2px(context, 160));

        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(anim3);
        mAnimatorSet.setDuration(1000);
        mAnimatorSet.start();
    }
    private void playLogoInAnim(){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv_logo, "scaleX", 1.0f, 0.5f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv_logo, "scaleY", 1.0f, 0.5f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv_logo, "y", mLogoY, DisplayUtil.dip2px(context, 15));

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
}
