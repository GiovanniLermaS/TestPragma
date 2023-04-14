package com.example.testpragma.view.main

import android.app.ProgressDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testpragma.databinding.ActivityMainBinding
import com.example.testpragma.view.main.adapter.CatAdapter
import com.example.testpragma.view.main.interfaces.ClickCity
import com.example.testpragma.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TextWatcher, ClickCity {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private lateinit var binding: ActivityMainBinding

    private val progress by lazy { ProgressDialog(this) }

    private var catAdapter: CatAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeActivityViewModel.listCats.observe(this) { listCats ->
            catAdapter = CatAdapter(listCats)
            binding.rvCats.adapter = catAdapter
            listCats.forEach { cat ->
                cat.imageId?.let { homeActivityViewModel.getImageCat(it) }
            }
            progress.dismiss()
        }
        homeActivityViewModel.image.observe(this) { image ->
            progress.dismiss()
            catAdapter?.addImage(image)
        }
        homeActivityViewModel.error.observe(this) {
            progress.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        homeActivityViewModel.getCats()
    }

    override fun onCitySelected(city: String?) {
        progress.show()
        homeActivityViewModel.getCats()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {}
}