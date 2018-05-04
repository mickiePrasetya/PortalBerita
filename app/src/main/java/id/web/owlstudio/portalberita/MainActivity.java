package id.web.owlstudio.portalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import id.web.owlstudio.portalberita.adapter.AdapterBerita;
import id.web.owlstudio.portalberita.network.ApiService;
import id.web.owlstudio.portalberita.network.InitRetrofit;
import id.web.owlstudio.portalberita.response.BeritaItem;
import id.web.owlstudio.portalberita.response.ResponseBerita;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // TODO 1 deklarasi variable global
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 2 Casting atau inisialisasi / hubungin ID
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tampilBerita();
    }

    private void tampilBerita() {
        ApiService service = InitRetrofit.getInstance();

        // siapkan request
        Call<ResponseBerita> beritaCall = service.requestAllBerita();

        // kirim request
        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                // membuat kondisi jika response berhasil
                if(response.isSuccessful()) {
                    List<BeritaItem> data_berita = response.body().getBerita();

                    boolean status = response.body().isStatus();
                    if(status) {
                        // panggil class Adapter untuk RecyclerVIew
                        AdapterBerita adapter = new AdapterBerita(MainActivity.this, data_berita);
                        recyclerView.setAdapter(adapter);

                    } else {
                        // Alert notifikasi berupa toast
                        Toast.makeText(MainActivity.this, "Tidak ada Berita", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                // print log jika ada error
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.logout ){
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
