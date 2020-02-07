package eu.mihau.testingnewthings.utils.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import eu.mihau.testingnewthings.BuildConfig
import eu.mihau.testingnewthings.api.APIService
import eu.mihau.testingnewthings.common.Values
import eu.mihau.testingnewthings.common.Values.INTERCEPTOR_CONTENT_TYPE
import eu.mihau.testingnewthings.utils.network.NoConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val restModule = module {
    single<OkHttpClient> {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val okHttpClientBuilder = OkHttpClient.Builder()

        okHttpClientBuilder
            .connectTimeout(Values.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .writeTimeout(Values.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .readTimeout(Values.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .callTimeout(Values.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(NoConnectionInterceptor(androidContext()))
            .addInterceptor {
                it.request().newBuilder()
                    .header("Content-Type", INTERCEPTOR_CONTENT_TYPE)
                    .build()
                    .let { request ->
                        it.proceed(request)
                    }
            }

        okHttpClientBuilder.build()
    }
    single<Gson> { GsonBuilder().create() }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }
    single<APIService> { get<Retrofit>().create<APIService>(APIService::class.java) }
}