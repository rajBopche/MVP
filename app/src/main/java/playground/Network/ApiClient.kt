package playground.Network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import playground.Utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            synchronized(this)
            {
                if (retrofit == null) {
                    val gson = Gson()
                    val logInterceptor = HttpLoggingInterceptor()
                    logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(logInterceptor).build()

                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClient)
                        .build()
                }
            }
            return retrofit as Retrofit
        }
    }
}




