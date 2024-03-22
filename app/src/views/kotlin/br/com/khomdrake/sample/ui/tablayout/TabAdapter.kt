package br.com.khomdrake.sample.ui.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(
    private val titles: List<String>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return TabFragment.instance(titles[position])
    }

    override fun getItemCount() = titles.size

}