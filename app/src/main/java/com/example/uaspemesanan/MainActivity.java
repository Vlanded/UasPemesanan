package com.example.uaspemesanan;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama;
    private Spinner spinnerMinuman;
    private EditText editTextJumlah;
    private Button buttonPesan;
    private TextView textViewTotal;

    private Map<String, Integer> hargaMinumanMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        spinnerMinuman = findViewById(R.id.spinnerMinuman);
        editTextJumlah = findViewById(R.id.editTextJumlah);
        buttonPesan = findViewById(R.id.buttonPesan);
        textViewTotal = findViewById(R.id.textViewTotal);

        // Inisialisasi spinner dengan daftar minuman
        String[] minumanArray = getResources().getStringArray(R.array.minuman_array);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, minumanArray);
        spinnerMinuman.setAdapter(spinnerAdapter);

        // Inisialisasi harga minuman
        hargaMinumanMap = new HashMap<>();
        hargaMinumanMap.put("Espresso", 10000);
        hargaMinumanMap.put("Latte", 20000);
        hargaMinumanMap.put("Cappuccino", 10000);
        hargaMinumanMap.put("Americano", 15000);
        hargaMinumanMap.put("Mocha", 15000);
        hargaMinumanMap.put("Macchiato", 20000);
    }

    public void pesanMinuman(View view) {
        String nama = editTextNama.getText().toString();
        String minuman = spinnerMinuman.getSelectedItem().toString();
        int jumlah = Integer.parseInt(editTextJumlah.getText().toString());

        if (!nama.isEmpty() && jumlah > 0) {
            int harga = hargaMinumanMap.get(minuman);
            int total = harga * jumlah;

            String hasilPemesanan = "Nama: " + nama + "\nMinuman: " + minuman + "\nJumlah: " + jumlah + "\nTotal: Rp " + total;
            textViewTotal.setText(hasilPemesanan);
        } else {
            textViewTotal.setText("Mohon isi semua data dengan benar.");
        }
    }
}
