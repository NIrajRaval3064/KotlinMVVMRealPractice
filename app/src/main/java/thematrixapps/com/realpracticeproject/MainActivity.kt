package thematrixapps.com.realpracticeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import thematrixapps.com.realpracticeproject.databinding.ActivityMainBinding
import thematrixapps.com.realpracticeproject.networkcall.RetrofitService
import thematrixapps.com.realpracticeproject.repository.MainRepository
import thematrixapps.com.realpracticeproject.viewmodel.MainViewModel
import thematrixapps.com.realpracticeproject.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        viewModel.employeeList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it.data)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })
        viewModel.getAllEmployee()


    }
}