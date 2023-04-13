package com.ankit.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ankit.mvvmnewsapp.R
import com.ankit.mvvmnewsapp.ui.MainActivity
import com.ankit.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    private val TAG = "ArticleFragment"
    private lateinit var viewModel: NewsViewModel
    private val arg : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ( activity as MainActivity).viewModel
        val article = arg.article
        Log.i(TAG, "An Error occurred $article")
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(it, "Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}