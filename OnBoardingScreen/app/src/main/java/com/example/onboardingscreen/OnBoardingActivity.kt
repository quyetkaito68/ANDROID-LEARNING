package com.example.onboardingscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import me.relex.circleindicator.CircleIndicator

class OnBoardingActivity : AppCompatActivity() {

    lateinit var tvSkip: TextView
    lateinit var viewPager: ViewPager
    lateinit var layoutCenter: RelativeLayout
    lateinit var layoutNext: LinearLayout
    lateinit var circleIndicator: CircleIndicator
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        initUI()
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        circleIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                if (position==2){
                    tvSkip.isVisible = false
                    layoutNext.isVisible = false
                }
                else{
                        tvSkip.isVisible = true
                        layoutNext.isVisible = true
                }
            }
        })
    }

    private fun initUI() {
        tvSkip = findViewById(R.id.tv_skip)
        viewPager = findViewById(R.id.view_pager)
        layoutCenter = findViewById(R.id.layout_center)
        layoutNext = findViewById(R.id.layout_next)
        circleIndicator = findViewById(R.id.circle_indicator)

        tvSkip.setOnClickListener {
            viewPager.setCurrentItem(2)

        }
        layoutNext.setOnClickListener{
            if (viewPager.currentItem < 2){
                viewPager.setCurrentItem(viewPager.currentItem +1)
            }
        }
    }
}