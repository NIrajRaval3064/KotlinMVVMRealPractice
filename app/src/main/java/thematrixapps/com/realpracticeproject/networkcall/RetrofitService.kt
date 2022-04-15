package thematrixapps.com.realpracticeproject.networkcall

import android.graphics.pdf.PdfDocument
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import thematrixapps.com.realpracticeproject.model.EmployeeList

interface RetrofitService {
    @GET("/api/users")
    fun getAllEmployeeList(
        @Query("page") page: Int
    ): Call<EmployeeList>


    companion object {

        var retrofitService: RetrofitService? = null

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}