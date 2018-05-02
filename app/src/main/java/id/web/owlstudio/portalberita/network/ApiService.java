package id.web.owlstudio.portalberita.network;

import id.web.owlstudio.portalberita.response.ResponseBerita;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tampil_berita.php")
    Call<ResponseBerita> requestAllBerita();

}
