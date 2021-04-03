package com.miguelhhtc.cocktaildemo.ui.main

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.miguelhhtc.cocktaildemo.ui.adapter.CocktailAdapter
import com.miguelhhtc.cocktaildemo.R
import com.miguelhhtc.cocktaildemo.model.DrinkItem
import com.miguelhhtc.cocktaildemo.ui.details.DetailActivity
import com.miguelhhtc.cocktaildemo.ui.adapter.Interaction
import com.miguelhhtc.cocktaildemo.utils.EXTRA_EXTERNAL_ID
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG: String = "MainActivity"
class MainActivity : AppCompatActivity(), Interaction {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private var layoutManager: GridLayoutManager? = null
    private var adapter: CocktailAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")

        layoutManager = GridLayoutManager(this, 1)
        rv_cocktail.layoutManager = layoutManager
        adapter = CocktailAdapter(this, layoutManager)
        rv_cocktail.adapter = adapter

        observeData()
    }

    private fun observeData(){
        viewModel.fetchCocktailData().observe(this, Observer {
            Log.i(TAG, "Received elements from view model" )
            adapter?.setCocktailList(it)
            adapter?.notifyDataSetChanged()
        })

    }

    override fun onItemSelected(position: Int, item: DrinkItem) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_EXTERNAL_ID, item.idDrink)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val searchItem = menu?.findItem(R.id.app_bar_search)
        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val searchView = searchItem?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.isIconified = true
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    viewModel.setup()
                }else {
                    Log.i(TAG, newText)
                    viewModel.fetchCocktailFilteredData(newText)
                }

                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_layout -> {
                if (layoutManager?.spanCount == 1) {
                    layoutManager?.spanCount = 2
                    item.title = "list"
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        item.icon = getDrawable(R.drawable.ic_baseline_view_list_24)
                    }
                } else {
                    layoutManager?.spanCount = 1
                    item.title = "grid"
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        item.icon = getDrawable(R.drawable.ic_baseline_grid_view_24)
                    }
                }
                adapter?.notifyItemRangeChanged(0, adapter?.itemCount ?: 0)
            }
        }
        return super.onOptionsItemSelected(item)
    }



}
