package com.example.univisiontest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.univisiontest.R

class ArticlesFragment : Fragment() {

    private lateinit var mViewModel: ArticlesViewModel

    companion object {
        val ARGUMENT_ARTICLES_ID = "ARTICLES_ID"
        fun newInstance() = ArticlesFragment()
    }

    private lateinit var viewModel: ArticlesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.articles_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(ArticlesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
