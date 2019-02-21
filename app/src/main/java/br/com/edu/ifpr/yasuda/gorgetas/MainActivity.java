package br.com.edu.ifpr.yasuda.gorgetas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  EditText tf_price;
    private  TextView tf_porcent;
    private  TextView tv_gorgeta;
    private  TextView tv_total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlaSeek();
    }

    @SuppressLint("SetTextI18n")
    public void controlaSeek(){
        SeekBar sb_porcent = findViewById(R.id.sb_porcent);
        tf_porcent = findViewById(R.id.tf_porcent);
        tf_porcent.setText(""+ sb_porcent.getProgress()+"%");

        sb_porcent.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int vl_progress;

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        vl_progress = progress;
                        tf_porcent.setText(""+progress+"%");

                        tf_price = findViewById(R.id.tf_price);
                        tv_gorgeta = findViewById(R.id.tv_gorgeta);
                        tv_total = findViewById(R.id.tv_total);

                        float a = Float.parseFloat(tf_price.getText().toString());
                        float b = a*Float.parseFloat(String.valueOf(progress));
                        float c = b/100;
                        Float d = c+Float.parseFloat(tf_price.getText().toString());

                        tv_gorgeta.setText("Gorgeta:    R$ "+c);
                        tv_total.setText("Gorgeta:    R$ "+d);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this,"SeekBar iniciada",Toast.LENGTH_LONG).show();
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        tf_porcent.setText(""+vl_progress+"%");
                    }
                }
        );

    }
}
