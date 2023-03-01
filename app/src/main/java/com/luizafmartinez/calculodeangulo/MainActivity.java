package com.luizafmartinez.calculodeangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText anguloEditText;
    private Button calcularButton;
    private RadioButton senoRadioButton, cossenoRadioButtton, tangenteRadioButton;
    private int intOpcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anguloEditText = (EditText) findViewById(R.id.edtValorAngulo);
        calcularButton = (Button) findViewById(R.id.btn_Calcular);
        senoRadioButton = (RadioButton) findViewById(R.id.rbSeno);
        cossenoRadioButtton = (RadioButton) findViewById(R.id.rbCosseno);
        tangenteRadioButton = (RadioButton) findViewById(R.id.rbTangente);

        calcularButton.setOnClickListener(this);
        senoRadioButton.setOnClickListener(this);
        cossenoRadioButtton.setOnClickListener(this);
        tangenteRadioButton.setOnClickListener(this);

        int opcao = 1;

    }

    public double CalcularSeno(double dblAngulo) {
        return Math.sin(Math.toRadians(dblAngulo));
    }

    public double CalcularCosseno(double dblAngulo) {
        return Math.cos(Math.toRadians(dblAngulo));
    }

    public double CalcularTangente(double dblAngulo) {
        return Math.tan(Math.toRadians(dblAngulo));
    }

    public void Calcular() {

        AlertDialog dlgAlerta;
        double dblAngulo, dblValorCalculo;
        String strAngulo, strTitulo;

        strAngulo = anguloEditText.getText().toString();

        if(strAngulo.equals(""))
            dblAngulo = 0;
        else
            dblAngulo = Double.parseDouble(strAngulo);

        if(dblAngulo > 0)     {
            if (intOpcao == 1) {
                dblValorCalculo = CalcularSeno(dblAngulo);
                strTitulo = "Cálculo de Seno";
            } else if (intOpcao == 2) {
                dblValorCalculo = CalcularCosseno(dblAngulo);
                strTitulo = "Cálculo de Cosseno";
            } else {
                dblValorCalculo = CalcularTangente(dblAngulo);
                strTitulo = "Cálculo de Tangente";
            }

            dlgAlerta = new AlertDialog.Builder(this).create();
            dlgAlerta.setTitle(strTitulo);
            dlgAlerta.setMessage(String.valueOf(dblValorCalculo));
            dlgAlerta.show();
    }

        else {
            dlgAlerta = new AlertDialog.Builder(this).create();
            dlgAlerta.setTitle("Aviso");
            dlgAlerta.setMessage("Somente são aceitos valores positivos !");
            dlgAlerta.show();
        }
}

@Override
public void onClick(View objeto) {

        switch(objeto.getId()) {

            case R.id.rbSeno:
                intOpcao = 1;
                cossenoRadioButtton.setChecked(false);
                tangenteRadioButton.setChecked(false);
                break;

            case R.id.rbCosseno:
                intOpcao = 2;
                senoRadioButton.setChecked(false);
                tangenteRadioButton.setChecked(false);
                break;

            case R.id.rbTangente:
                intOpcao = 3;
                senoRadioButton.setChecked(false);
                cossenoRadioButtton.setChecked(false);
                break;

            case R.id.btn_Calcular:
                Calcular();
                break;
        }
}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
