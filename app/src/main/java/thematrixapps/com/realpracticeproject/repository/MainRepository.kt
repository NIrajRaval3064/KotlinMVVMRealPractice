package thematrixapps.com.realpracticeproject.repository

import thematrixapps.com.realpracticeproject.networkcall.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllEmployeeList()=retrofitService.getAllEmployeeList(1)
}