package id.web.owlstudio.portalberita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    // TODO 1 deklarasi variable global
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 2 Casting atau inisialisasi / hubungin ID
        recyclerView = findViewById(R.id.recyclerview);
    }
}
