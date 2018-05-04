package id.web.owlstudio.portalberita.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.web.owlstudio.portalberita.R;

public class DetailActivity extends AppCompatActivity {

    // TODO 1 Declare Widget dari layout activity_detail.xml dan layout content_detail.xml
    private ImageView imgBerita;
    private TextView tvTglTerbit, tvPenulis;
    private WebView wvContentBerita;

    // TODO 3 Buat Variable Penampung untuk Get all Data - Adapter terkirim
    public static final String JDL = "judul_berita";
    public static final String TGL = "tgl_berite";
    public static final String PNS = "pns_berita";
    public static final String ISI = "isi_berita";
    public static final String FOTO = "foto_berita";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO 2 Initialize ID
        imgBerita = findViewById(R.id.ivGambarBerita);
        tvTglTerbit = findViewById(R.id.tvTglTerbit);
        tvPenulis = findViewById(R.id.tvPenulis);
        wvContentBerita = findViewById(R.id.wvContentBerita);

        // TODO 3 buat method untuk get data dari intent
        tampilBerita();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void tampilBerita() {

        // tangkap data dari intent
        String judulBerita = getIntent().getStringExtra(JDL);
        String tanggalBerita = getIntent().getStringExtra(TGL);
        String penulisBerita = getIntent().getStringExtra(PNS);
        String isiBerita = getIntent().getStringExtra(ISI);
        String fotoBerita = getIntent().getStringExtra(FOTO);

        tvPenulis.setText(penulisBerita);
        tvTglTerbit.setText(tanggalBerita);

        // set judul action / toolbar
        getSupportActionBar().setTitle(judulBerita);

        // untuk load gambar lagi
        Picasso.with(this).load(fotoBerita).into(imgBerita);

        // set isi berita sebagai html ke webview
        wvContentBerita.getSettings().setJavaScriptEnabled(true);
        wvContentBerita.loadData(isiBerita, "text/html; charset=utf-8", "UTF-8");
    }
}
