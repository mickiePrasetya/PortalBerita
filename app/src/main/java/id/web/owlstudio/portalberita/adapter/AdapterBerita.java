package id.web.owlstudio.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.web.owlstudio.portalberita.R;
import id.web.owlstudio.portalberita.response.BeritaItem;
import id.web.owlstudio.portalberita.ui.DetailActivity;

import static id.web.owlstudio.portalberita.network.InitRetrofit.API_URL;
import static id.web.owlstudio.portalberita.ui.DetailActivity.FOTO;
import static id.web.owlstudio.portalberita.ui.DetailActivity.ISI;
import static id.web.owlstudio.portalberita.ui.DetailActivity.JDL;
import static id.web.owlstudio.portalberita.ui.DetailActivity.PNS;
import static id.web.owlstudio.portalberita.ui.DetailActivity.TGL;

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
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerita.ViewHolder holder, final int position) {
        // set widget
        holder.tvJudulBerita.setText(berita.get(position).getJudulBerita());
        holder.tvTglBerita.setText(berita.get(position).getTanggalPosting());
        holder.tvPenulis.setText(berita.get(position).getPenulis());

        // get URL Images
        final String urlImageBerita = API_URL + "images/" + berita.get(position).getFoto();

        // ambil gambar dari Picasso
        Picasso.with(c).load(urlImageBerita).into(holder.ivBerita);

        // ketika item list diklik pindah ke detail activity dengan membawa data
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(c, DetailActivity.class);

                //
                // mulai kirim data
                i.putExtra(JDL, berita.get(position).getIsiBerita());
                i.putExtra(TGL, berita.get(position).getTanggalPosting());
                i.putExtra(PNS, berita.get(position).getPenulis());
                i.putExtra(ISI, berita.get(position).getIsiBerita());
                i.putExtra(FOTO, urlImageBerita);

                c.startActivity(i);

            }
        });
    }

    // menentukan jumlah data item yang tampil
    @Override
    public int getItemCount() {
        return berita.size();
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
