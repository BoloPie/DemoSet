package com.example.demoset.ui.action;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demoset.R;
import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.ChangeImageTransform;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Recolor;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import android.support.transition.TransitionManager;

/**
 * 场景和变换动画
 */
public class ScenesTransitionsActivity extends AppCompatActivity {
/*
* 动画效果ChangeBounds它能够处理View本身大小、位置改变
* 在Transition框架中，对于过渡效果的抽象就是Transition类，框架内置了一些常用的效果，比如幻灯片 Slide,淡入淡出 Fade
* 1.场景 Scenes
* 来记录一个场景的
* 2.过渡 Transition
* Transition针对start场景和end场景视图树中View的一些属性，比如width，height，position，visibility等的变化，
* 定义了过渡的效果。系统内置了changebounds、fade、slide等效果。
* 3.开启动画--通过TransitionManager就可以开启动画：
* */

    @Bind(R.id.activity_scenes_transitions_button)
    Button button;
    @Bind(R.id.activity_scenes_transitions_text)
    TextView textTV;
    @Bind(R.id.activity_scenes_transitions)
    ViewGroup container;
    @Bind(R.id.activity_scenes_transitions_iv)
    ImageView imageView;
    @Bind(R.id.activity_scenes_transitions_btn)
    Button pathBtn;
    @Bind(R.id.activity_scenes_transitions_TransitionName_layout)
    LinearLayout transitionNameLayout;
    @Bind(R.id.activity_scenes_transitions_Scale_btn)
    Button scaleBtn;
    @Bind(R.id.activity_scenes_transitions_Scale_tv)
    TextView scaleTv;
    @Bind(R.id.activity_scenes_transitions_Rotate_iv)
    ImageView rotateIv;
    @Bind(R.id.activity_scenes_transitions_ChangeText_tv)
    TextView changeTextTv;

    boolean visible;
    boolean expanded;
    boolean isReturnAnimation;
    boolean isColorsInverted;
    boolean isRotated;
    boolean isSecondText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes_transitions);
        ButterKnife.bind(this);

//     3.   Explode and Propagation (粒子扩散) ---recycleview


    }


    @OnClick(R.id.activity_scenes_transitions_button)
    public void onViewClicked() {

//     1.   基础动画
//        TransitionManager.beginDelayedTransition(container);
//      2.  Slide （滑行）
        TransitionManager.beginDelayedTransition(container, new Slide(Gravity.RIGHT));

        visible = !visible;
        textTV.setVisibility(visible ? View.VISIBLE : View.GONE);

    }

    //     4.   ChangeImageTransform 可以对一个图片的矩阵信息进行变换
    @OnClick(R.id.activity_scenes_transitions_iv)
    public void onImageViewClicked() {
        TransitionManager.beginDelayedTransition(container, new TransitionSet()
                .addTransition(new ChangeBounds())
                .addTransition(new ChangeImageTransform()));
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.height = expanded ? ViewGroup.LayoutParams.MATCH_PARENT : ViewGroup.LayoutParams.WRAP_CONTENT;
        imageView.setLayoutParams(params);
        imageView.setScaleType(expanded ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);

        expanded = !expanded;
    }

    //     5. Path (路径) 动画
    @OnClick(R.id.activity_scenes_transitions_btn)
    public void onPathViewClicked() {

        TransitionManager.beginDelayedTransition(container,
                new ChangeBounds().setPathMotion(new ArcMotion()).setDuration(500));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) pathBtn.getLayoutParams();
        params.gravity = isReturnAnimation ? (Gravity.LEFT | Gravity.TOP) : (Gravity.BOTTOM | Gravity.RIGHT);
        pathBtn.setLayoutParams(params);
        isReturnAnimation = !isReturnAnimation;
    }

    //   6.TransitionName 当我们需要移除父容器内所有的 view，然后再增加一些新的 view。哪些元素是被移除的，哪些元素是需要移动到新的位置
    @OnClick(R.id.activity_scenes_transitions_TransitionName_btn)
    public void onTransitionNameViewClicked() {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            titles.add("item" + i);
        }

        TransitionManager.beginDelayedTransition(transitionNameLayout);
        Collections.shuffle(titles);
        createViews(transitionNameLayout, titles);
    }

    // In createViews we should provide transition name for every view.
    private void createViews(ViewGroup layout, List<String> titles) {
        layout.removeAllViews();
        LayoutInflater inflater = getLayoutInflater();
        for (String title : titles) {
            TextView textTV = (TextView) inflater.inflate(R.layout.action_textview, layout, false);
            textTV.setText(title);
            TransitionManager.setTransitionName(textTV, title);
            layout.addView(textTV);
        }
    }


    @OnClick(R.id.activity_scenes_transitions_Scale_btn)
    public void onScaleViewClicked() {

        //  7. Scale在 view 的可见性变换时做缩放动画，只需要添加 new Scale() 就可以了。
        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7F))
                .addTransition(new Fade())
                .setInterpolator(visible ? new LinearOutSlowInInterpolator() : new FastOutLinearInInterpolator());
        TransitionManager.beginDelayedTransition(container, set);
        scaleTv.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        visible = !visible;

        // 8. Recolor它能给 View 的背景，TextView 的字体颜色加上颜色渐变动画：
        TransitionManager.beginDelayedTransition(container, new Recolor());
        scaleBtn.setTextColor(ContextCompat.getColor(this,
                !isColorsInverted ? R.color.color_red_300 : R.color.color_teal_200));
        scaleBtn.setBackgroundResource(!isColorsInverted ? R.color.color_teal_200 : R.color.color_red_300);
        isColorsInverted = !isColorsInverted;


    }

    String TEXT1 = "Thanks";
    String TEXT2 = "Another";

    @OnClick(R.id.activity_scenes_transitions_Rotate_iv)
    public void onRotateViewClicked() {
        // 9.  Rotate
        TransitionManager.beginDelayedTransition(container, new Rotate());
        rotateIv.setRotation(isRotated ? 135 : 0);
        isRotated = !isRotated;

        //  10. ChangeText可以给 TextView 的文本内容变换加上淡入淡出动画：
        TransitionManager.beginDelayedTransition(container,
                new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
        changeTextTv.setText(isSecondText ? TEXT1 : TEXT2);
        isSecondText = !isSecondText;

    }
}



