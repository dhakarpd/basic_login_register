package com.example.demo_basic

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/*Fragment Manager is the class responsible for performing actions on ur app's fragments, such as
  adding, removing or replacing them to back stack;

  For a fragment to transition through rest of its lifecycle, it must be added to Fragment Manager.
  The Fragment Manager is responsible for determining what state its fragment should be in and
  then moving them into that state

  Adapter used to connect fragments to viewpager
  ViewPager2 uses FragmentStateAdapter objects as supply for new pages to display; createFragment()
  method is implemented to supply instances of screenslidepagefragment as new pages*/

class PageAdapter(fragManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragManager, lifecycle) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
      return when (position) {
          0 -> {
              PersonalDetailsFragment()
          }
          1 -> {
              EducationDetailsFragment()
          }
          2 -> {
              FinancialDetailsFragment()
          }
          3 -> {
              FamilyDetailsFragment()
          }
          else -> {
              PersonalDetailsFragment()
          }
      }
    }
}