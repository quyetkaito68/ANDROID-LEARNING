 package com.example.animation
 import android.os.Bundle
 import android.view.LayoutInflater
 import android.view.View
 import android.view.ViewGroup
 import android.widget.TextView
 import androidx.fragment.app.Fragment
 import kotlinx.android.synthetic.main.fragment_one.*

 class FragmentTwo : Fragment() {
    lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        text_fragment_one.text = "Fragment Two"
    }


}