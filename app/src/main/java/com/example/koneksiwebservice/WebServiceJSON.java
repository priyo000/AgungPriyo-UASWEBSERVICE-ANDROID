package com.example.koneksiwebservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebServiceJSON extends AppCompatActivity {
    private EditText input;
    private TextView tnama;
    private TextView tid;
    private TextView tasal;
    private TextView tkamar;
    private TextView tsuhu;
    private TextView tlembap;
    private RequestQueue ueue;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_json);

        ueue = Volley.newRequestQueue(this);
        Button btnJson = findViewById(R.id.btnparse);
        input = findViewById(R.id.inputnya);
        tnama = findViewById(R.id.tvnama);
        tid = findViewById(R.id.tvid);
        tasal = findViewById(R.id.tvasal);
        tkamar = findViewById(R.id.tvkamar);
        tsuhu = findViewById(R.id.tvsuhu);
        tlembap = findViewById(R.id.tvlembap);

        btnJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals("")){
                    index =0;
                }else {
                    index = Integer.parseInt(String.valueOf(input.getText()))-1;
                }
                uraiJSON(index);
            }
        });
    }

    private void uraiJSON(final int index){
        String url = "http://papaside.com/data.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                        JSONObject jsonnye = response.getJSONObject(index);

                        String idnye = jsonnye.getString("Kota");
                        String namanye = jsonnye.getString("siang");
                        String asalnye = jsonnye.getString("malam");
                        String kamarnye = jsonnye.getString("dini_hari");
                        String suhu = jsonnye.getString("suhu");
                        String lembap = jsonnye.getString("Kelembapan");

                        tid.setText(idnye);
                        tnama.setText(namanye);
                        tasal.setText(asalnye);
                        tkamar.setText(kamarnye);
                        tsuhu.setText(suhu);
                        tlembap.setText(lembap);


                }
                catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        ueue.add(request);
    }
}
