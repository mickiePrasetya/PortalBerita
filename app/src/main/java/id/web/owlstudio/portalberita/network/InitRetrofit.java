package id.web.owlstudio.portalberita.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {

    // URL Server API
    public static String API_URL = "http://192.168.56.1/portal_berita/";

    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }

}
