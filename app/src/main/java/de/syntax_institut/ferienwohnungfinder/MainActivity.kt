package de.syntax_institut.ferienwohnungfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntax_institut.ferienwohnungfinder.adapter.AppartmentAdapter
import de.syntax_institut.ferienwohnungfinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.rvAppartmentList.layoutManager = LinearLayoutManager(this)
        binding.rvAppartmentList.hasFixedSize()
        viewModel.appartments.observe(this){
            binding.rvAppartmentList.adapter = AppartmentAdapter(it)
        }
    }
}
