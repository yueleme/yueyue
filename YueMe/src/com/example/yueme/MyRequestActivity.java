package com.example.yueme;

import java.util.ArrayList;

import com.nineoldandroids.view.ViewPropertyAnimator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyRequestActivity extends AppCompatActivity{
	
	private ArrayList<Fragment> fragments;
	private Toolbar toolbar;
    private TextView tvPut;
    private TextView tvGet;
    private View vLine;
    private ViewPager viewPager;
	
    @Override
	  protected void onCreate(Bundle savedInstanceState){
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_my_request);
	     initView();
	  }
	     
	  private void  initView(){
		     toolbar = (Toolbar) findViewById(R.id.main_toolbar);
		     tvPut = (TextView) findViewById(R.id.tab_put);
		     tvGet = (TextView) findViewById(R.id.tab_get);
		     vLine = (View) findViewById(R.id.tab_line);
		     viewPager = (ViewPager) findViewById(R.id.viewPager);
		     
		     initToolbar();
		     initFragments();
		  }
	  
	  /**
	   * 初始化标题栏
	   */
	  private void initToolbar(){  
		    //设置Toolbar标题
	    	toolbar.setTitle("我的约单");
	    	//设置标题颜色
	        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
	        //设置默认标题栏为toolbar
	        setSupportActionBar(toolbar);
	        //设置返回键可用
	        getSupportActionBar().setHomeButtonEnabled(true); 
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    	
	        
	        toolbar.setNavigationOnClickListener(new OnClickListener(){
	        	@Override
	        	public void onClick(View v){
	        		finish();
	        	}
	        });
	  }
	     
	  private void initFragments(){
	    	 fragments = new ArrayList<Fragment>();
	 		 fragments.add(new MyPutRequestFragment());
	 		 fragments.add(new MyGetRequestFragment());
	 		 
	 		 vLine.getLayoutParams().width = getWindowManager().getDefaultDisplay().getWidth()
	 				/ fragments.size();
	 		 vLine.requestLayout();
	 		 
	 		 viewPager.setAdapter(new FragmentStatePagerAdapter(
					getSupportFragmentManager()) {

				@Override
				public int getCount() {
					return fragments.size();
				}

				@Override
				public Fragment getItem(int arg0) {
					return fragments.get(arg0);
				}
			});

			viewPager.setOnPageChangeListener(new OnPageChangeListener() {

				@Override
				public void onPageSelected(int arg0) {
					changeState(arg0);
				}

				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					//切换条的动画效果
					int line_width = getWindowManager().getDefaultDisplay().getWidth()
						/ fragments.size();
					float tagerX = arg0 * line_width + arg2 / fragments.size();
					ViewPropertyAnimator.animate(vLine).translationX(tagerX)
							.setDuration(0);
				}

				@Override
				public void onPageScrollStateChanged(int arg0) {

				}
			});

			tvPut.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					viewPager.setCurrentItem(0);
//					initData();
				}
			});

			tvGet.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					viewPager.setCurrentItem(1);
				}
			});
	     }
	  
	  /* 根据传入的值来改变状态 */
		private void changeState(int arg0) {
			if (arg0 == 0) {
				tvPut.setTextColor(getResources().getColor(R.color.blue));
				tvGet.setTextColor(getResources().getColor(R.color.black));
				ViewPropertyAnimator.animate(tvPut).scaleX(1.2f).setDuration(200);
				ViewPropertyAnimator.animate(tvPut).scaleY(1.2f).setDuration(200);
				ViewPropertyAnimator.animate(tvGet).scaleX(1.0f)
						.setDuration(200);
				ViewPropertyAnimator.animate(tvGet).scaleY(1.0f)
						.setDuration(200);

			} else {
				tvGet.setTextColor(getResources().getColor(R.color.blue));
				tvPut.setTextColor(getResources().getColor(R.color.black));
				ViewPropertyAnimator.animate(tvGet).scaleX(1.2f).setDuration(200);
				ViewPropertyAnimator.animate(tvGet).scaleY(1.2f).setDuration(200);
				ViewPropertyAnimator.animate(tvPut).scaleX(1.0f)
						.setDuration(200);
				ViewPropertyAnimator.animate(tvPut).scaleY(1.0f)
						.setDuration(200);
			}
		}

}
