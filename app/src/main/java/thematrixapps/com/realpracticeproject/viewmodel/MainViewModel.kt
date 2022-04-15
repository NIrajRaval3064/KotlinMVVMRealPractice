package thematrixapps.com.realpracticeproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import thematrixapps.com.realpracticeproject.model.EmployeeList
import thematrixapps.com.realpracticeproject.repository.MainRepository

class MainViewModel(private val repository: MainRepository):ViewModel()
{
    val employeeList= MutableLiveData<EmployeeList>()
    val errorMessage=MutableLiveData<String>()

    fun getAllEmployee(){
        val response=repository.getAllEmployeeList()
        response.enqueue(object : Callback<EmployeeList>{
            override fun onResponse(call: Call<EmployeeList>, response: Response<EmployeeList>) {
                employeeList.postValue(response.body())
            }

            override fun onFailure(call: Call<EmployeeList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("MainviewModel","Cleared")
    }
}