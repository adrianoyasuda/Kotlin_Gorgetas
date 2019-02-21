package br.com.edu.ifpr.yasuda.gorgetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText tf_price;
    private static SeekBar sb_porcent;
    private static TextView tf_porcent;
    private static TextView tv_gorgeta;
    private static TextView tv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlaSeek();
    }

    public void controlaSeek(){
        sb_porcent = (SeekBar)findViewById(R.id.sb_porcent);
        tf_porcent = (TextView)findViewById(R.id.tf_porcent);
        tf_porcent.setText(""+sb_porcent.getProgress()+"%");

        sb_porcent.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int vl_progress;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        vl_progress = progress;
                        tf_porcent.setText(""+progress+"%");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this,"SeekBar iniciada",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        tf_porcent.setText(""+vl_progress+"%");
                    }
                }
        );

        tf_price = (EditText)findViewById(R.id.tf_price);
        tv_gorgeta = (TextView)findViewById(R.id.tv_gorgeta);
        tv_total = (TextView)findViewById(R.id.tv_total);

    }
}
