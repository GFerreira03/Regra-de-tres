package br.com.gabrielferreira.prova_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Componentes
    EditText topLeftInput;
    EditText botLeftInput;
    EditText topRightInput;

    Button respButton;
    Button deleteButton;
    Button exitButton;

    RadioGroup rGroup;
    RadioButton rButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeftInput = (EditText)findViewById(R.id.topLeftInput);
        botLeftInput = (EditText)findViewById(R.id.bottomLeftInput);
        topRightInput = (EditText)findViewById(R.id.topRightInput);

        respButton = (Button)findViewById(R.id.responseOutput);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        exitButton = (Button)findViewById(R.id.exitButton);

        rGroup = (RadioGroup)findViewById(R.id.radioProporcao);

        respButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    if (!topRightInput.getText().toString().trim().isEmpty() && !topLeftInput.getText().toString().trim().isEmpty() && !botLeftInput.getText().toString().trim().isEmpty()) {
                        int radioId = rGroup.getCheckedRadioButtonId();
                        rButton = findViewById(radioId);
                        if (rButton.getText().toString().equals("Diretamente")) {
                            respButton.setText(Float.toString((regraD3(Float.parseFloat(botLeftInput.getText().toString()), Float.parseFloat(topRightInput.getText().toString()), Float.parseFloat(topLeftInput.getText().toString())))));

                        } else {
                            respButton.setText(Float.toString((regraD3(Float.parseFloat(topLeftInput.getText().toString()), Float.parseFloat(topRightInput.getText().toString()), Float.parseFloat(botLeftInput.getText().toString())))));
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Campos foram deixados em branco.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                topLeftInput.setText(null);
                topRightInput.setText(null);
                botLeftInput.setText(null);
                respButton.setText("Resultado");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Agradecimentos.class));
                finish();
            }
        });
    }
        float regraD3(float n1, float n2, float n3){
            return ((n1 * n2) / n3);
        }
    }