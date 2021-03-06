package com.eugenebrusov.news.newsdetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugenebrusov.news.ViewModelFactory
import com.eugenebrusov.news.databinding.FragmentNewsDetailsBinding

/**
 * Main UI for the news detail screen
 */
class NewsDetailFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNewsDetailsBinding
                .inflate(inflater, container, false)
                .apply {
                    setLifecycleOwner(this@NewsDetailFragment)
                }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelFactory.obtainViewModel(activity!!, NewsDetailViewModel::class.java)
        binding.viewModel = viewModel
    }

}
