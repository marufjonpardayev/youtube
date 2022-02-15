package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.adapter.FeedAdapter
import com.example.youtube.adapter.FilterAdapter
import com.example.youtube.model.Feed
import com.example.youtube.model.Filter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerFeed: RecyclerView
    private lateinit var recyclerFilter: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFilter=findViewById(R.id.recycler_filter)
        recyclerFilter.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerFeed=findViewById(R.id.recycler_feed)
        recyclerFeed.layoutManager=LinearLayoutManager(this)
        refreshFilterAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())


    }
    fun refreshFeedAdapter(feeds:ArrayList<Feed>){
        val adapter=FeedAdapter(this,feeds)
        recyclerFeed.adapter=adapter
    }
    fun refreshFilterAdapter(filtes:ArrayList<Filter>){
        val adapter=FilterAdapter(this,filtes)
        recyclerFilter.adapter=adapter
    }
    fun getAllFilters():ArrayList<Filter>{
        val filters:ArrayList<Filter> = ArrayList()
        filters.add((Filter("Computer Programming")))
        filters.add((Filter("Android native")))
        filters.add((Filter("Mobile Development")))
        filters.add((Filter("Funny videos")))
        return filters
    }
    fun getAllFeeds():ArrayList<Feed>{
        val feeds:ArrayList<Feed> = ArrayList()
        feeds.add(Feed(R.drawable.image_telegram,R.drawable.photo1))
        feeds.add(Feed(R.drawable.saidahmad,R.drawable.photo2))
        feeds.add(Feed(R.drawable.image_gamer,R.drawable.photo3))
        feeds.add(Feed(R.drawable.mirzohid,R.drawable.photo4))
        feeds.add(Feed(R.drawable.saidahmad,R.drawable.photo1))
        feeds.add(Feed(R.drawable.image_gamer,R.drawable.photo3))
        feeds.add(Feed(R.drawable.mirshod,R.drawable.photo4))
        return feeds
    }
}