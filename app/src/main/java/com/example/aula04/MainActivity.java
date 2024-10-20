package com.example.aula04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula04.model.Professor;
import com.example.aula04.model.ProfessorHorista;
import com.example.aula04.model.ProfessorTitular;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private EditText etHoras;
    private EditText etValor;
    private Button btnCalc;
    private TextView tvRes;
    private EditText etAnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbHorista);
        etHoras = findViewById(R.id.etHoras);
        etValor = findViewById(R.id.etValor);
        btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);
        etAnos = findViewById(R.id.etAnos);
        
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        int horas = Integer.parseInt(etHoras.getText().toString());
        double valor = Double.parseDouble(etValor.getText().toString());
        if(rbTitular.isChecked()) {
            ProfessorTitular professorTitular = new ProfessorTitular();
            professorTitular.setAnosInstituicao(Integer.parseInt(etAnos.getText().toString()));
            double sal = professorTitular.calcSalario(horas, valor);
            BigDecimal salario = BigDecimal.valueOf(sal).setScale(2, RoundingMode.HALF_UP);
            tvRes.setText(getString(R.string.Salario) + salario);

        }
        if(rbHorista.isChecked()) {
            ProfessorHorista professorHorista = new ProfessorHorista();
            double sal = professorHorista.calcSalario(horas, valor);
            BigDecimal salario = BigDecimal.valueOf(sal).setScale(2, RoundingMode.HALF_UP);
            tvRes.setText(getString(R.string.Salario) + salario);
        }
    }
}