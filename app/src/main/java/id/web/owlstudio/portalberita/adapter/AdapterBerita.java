package id.web.owlstudio.portalberita.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.web.owlstudio.portalberita.R;
import id.web.owlstudio.portalberita.response.BeritaItem;

// TODO 1
public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder>{

    // TODO 2 Deklarasi Variable
    Context c;
    List<BeritaItem> berita;

    // TODO 3 Buat Constructor dari class AdapterBerita
    public AdapterBerita(Context cc, List<BeritaItem> data_berita) {
        this.c = cc;
        this.berita = data_berita;
    }

    @NonNull
    @Override
    public AdapterBerita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // TODO 4 Masukin layout item_berita.xml
        View v = LayoutInflater.from(c).inflate(R.layout.item_berita, parent, false);


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerita.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // TODO 5 Deklarasi dan buat Variablenya
        private TextView tvJudulBerita, tvTglBerita, tvPenulis;
        private ImageView ivBerita;

        public ViewHolder(View itemView) {
            super(itemView);

            // TODO 6 Hubungin ke ID-nya masing-masing
            tvJudulBerita = itemView.findViewById(R.id.tv_judul_berita);
            tvTglBerita = itemView.findViewById(R.id.tv_tgl_terbit);
            tvPenulis = itemView.findViewById(R.id.tv_penulis);
            
            ivBerita = itemView.findViewById(R.id.iv_berita);

        }
    }
}
