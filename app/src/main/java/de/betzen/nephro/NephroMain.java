package de.betzen.nephro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NephroMain extends AppCompatActivity implements View.OnClickListener {

    private final String DEBUGOUT = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kofmain);

        Button button = findViewById(R.id.buttonBerechnen);
        button.setOnClickListener(this);

        Log.d(DEBUGOUT, "Hallo Welt!");
    }

    @Override
    public void onClick(View v) {
        EditText etLaenge = findViewById(R.id.editTextLaenge);
        EditText etGewicht = findViewById(R.id.editTextGewicht);

        Editable Laenge = etLaenge.getText();
        Editable Gewicht = etGewicht.getText();

        if(Laenge.length() == 0 || Gewicht.length() == 0)
            return;

        Double l = Double.parseDouble(Laenge.toString());
        Double g = Double.parseDouble(Gewicht.toString());

        Double kof = Math.sqrt(l*g/3600);

        TextView tvKOF = findViewById(R.id.textViewKOF);
        TextView tvPerspiratio = findViewById(R.id.textViewPerspiratio);
        TextView tvPolyurie= findViewById(R.id.textViewPolyurie);
        TextView tvOligurie = findViewById(R.id.textViewOligurie);
        TextView tvAnurie = findViewById(R.id.textViewAnurie);

        Double perspiratio = kof * 400;
        Double polyurie = kof * 2000;
        Double oligurie = kof * 240;
        Double anurie = kof * 100;


        tvKOF.setText(String.format("%.2f",kof)+ " m²");
        tvPerspiratio.setText(String.format("%d",perspiratio.intValue())+ " ml/m²/d");
        tvPolyurie.setText(String.format("%d",polyurie.intValue())+ " ml/d");
        tvOligurie.setText(String.format("%d",oligurie.intValue())+ " ml/d");
        tvAnurie.setText(String.format("%d",anurie.intValue())+ " ml/d");

    }
}
