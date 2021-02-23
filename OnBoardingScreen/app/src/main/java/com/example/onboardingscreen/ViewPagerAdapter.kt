package com.example.onboardingscreen

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return OnBoadingFragment1()
            }
            1 -> {
                return OnBoadingFragment2()
            }
            2 -> {
                return OnBoadingFragment3()
            }
        }
        return OnBoadingFragment1()
    }
}