package com.example.demo_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        submit_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val actionBar = supportActionBar
        if (actionBar!=null){
            actionBar.title= "Registered User Page"
        }


        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter=PageAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter

        /* TabLayoutMediator ->It will synchronize ViewPager2's position with the selected tab, acts
           as link btw tablayout and viewpager. Instantiating TabLayoutMediator will only create
           mediator object, attach() will link both together */
        TabLayoutMediator(tabLayout,viewPager2){tab, position ->
            when(position){
                0->{
                    tab.text="Personal Details"
                }
                1->{
                    tab.text="Education Details"
                }
                2-> {
                    tab.text = "Financial Details"
                }
                3-> {
                    tab.text = "Family Details"
                }
            }
        }.attach()

    }
}