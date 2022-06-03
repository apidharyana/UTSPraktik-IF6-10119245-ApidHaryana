package com.example.utspraktik_if6_10119245_apidharyana;

/*
   Jum'at 03 Juni 2022
   NIM   : 10119245
   Nama  : Apid Haryana
   Kelas : IF - 6
*/

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_NIK = "nik";
    public static final String EXTRA_TGL = "tgl";
    public static final String EXTRA_KELAMIN = "kelamin";
    public static final String EXTRA_HUBUNGAN = "hubungan";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_TES = "tes";
    public static final String EXTRA_TGLKON = "tglkon";


    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String tes = intent.getStringExtra(MainActivity.EXTRA_TES);
        String tglkon = intent.getStringExtra(MainActivity.EXTRA_TGLKON);
        String nik = intent.getStringExtra(MainActivity.EXTRA_NIK);
        String nama = intent.getStringExtra(MainActivity.EXTRA_NAMA);
        String jk = intent.getStringExtra(MainActivity.EXTRA_KELAMIN);
        String tgl = intent.getStringExtra(MainActivity.EXTRA_TGL);
        String hub = intent.getStringExtra(MainActivity.EXTRA_HUBUNGAN);

        TextView tvTes = findViewById(R.id.j_tes);
        TextView tvTglKon = findViewById(R.id.j_tglkon);
        TextView tvNik = findViewById(R.id.j_nik);
        TextView tvNama = findViewById(R.id.j_nama);
        TextView tvTgl = findViewById(R.id.j_tgl);
        TextView tvHub = findViewById(R.id.j_hub);
        TextView tvJk = findViewById(R.id.j_jk);
        Button btn_simpan= findViewById(R.id.btn_simpan);
        Button btn_ubah= findViewById(R.id.btn_ubah);



        tvTes.setText(tes);
        tvTglKon.setText(tglkon);
        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTgl.setText(tgl);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_simpan.setOnClickListener(view -> customDialog.show());

        btn_ubah.setOnClickListener(view -> {
            intent2.putExtra(EXTRA_TES,tes);
            intent2.putExtra(EXTRA_TGLKON,tglkon);
            intent2.putExtra(EXTRA_STATUS,"ubah");
            intent2.putExtra(EXTRA_NIK,nik);
            intent2.putExtra(EXTRA_NAMA,nama);
            intent2.putExtra(EXTRA_TGL,tgl);
            intent2.putExtra(EXTRA_KELAMIN,jk);
            intent2.putExtra(EXTRA_HUBUNGAN,hub);


            startActivity(intent2);
        });
    }

    private void initCustomDialog(){

        customDialog = new Dialog(MainActivity2.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_main3);
        customDialog.setCancelable(true);



        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(v -> customDialog.dismiss());
    }
}
