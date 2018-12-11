package playground.Network

import io.reactivex.Observable
import playground.Model.LoginData
import playground.Model.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {


    @FormUrlEncoded
    @POST("users/login")
    fun login(@Field("email")userEmail:String,@Field("password") userPassword:String):Observable<LoginResponse>


}