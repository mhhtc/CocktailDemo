package com.miguelhhtc.cocktaildemo.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.miguelhhtc.cocktaildemo.R
import com.miguelhhtc.cocktaildemo.utils.EXTRA_EXTERNAL_ID
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*


private const val TAG: String = "DetailActivity"

class DetailActivity : AppCompatActivity() {

    var drinkID:Int = 0
    private val viewModel by lazy { ViewModelProvider(this).get(DetailViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drinkID = intent.getIntExtra(EXTRA_EXTERNAL_ID, -1)

        observeData()
    }

    @SuppressLint("SetTextI18n")
    private fun observeData(){
        viewModel.fetchCocktailDetailData(drinkID).observe(this, Observer {
            setTitle(it.strDrink?.capitalize(Locale.ROOT))

            tv_category.text = it.strCategory?.capitalize(Locale.ROOT)
            tv_alcoholic.text = it.strAlcoholic?.capitalize(Locale.ROOT)

            tv_id.text = "#${it.idDrink.toString()}"

            if (it.dateModified != null)
                tv_date.text = it.dateModified
            else
                tv_date.text = "-"

            tv_instructions.text = it.strInstructions

            tag_group.setTags(it.getIngredientsList())

            Glide.with(iv_image)
                .load(it.strDrinkThumb)
                .centerInside()
                .into(iv_image)

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}