package com.example.instagramcurso.login.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.instagramcurso.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TestButton buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextEmail = findViewById(R.id.login_edit_text_email);
        final EditText editTextPassword = findViewById(R.id.login_edit_text_password);

        //listener para quando o texto mudar
        editTextEmail.addTextChangedListener(watcher);
        editTextPassword.addTextChangedListener(watcher);

        buttonEnter = findViewById(R.id.login_button_enter);
        buttonEnter.setOnClickListener(v -> {
            buttonEnter.showProgress(true);

            new Handler().postDelayed(() ->{
            buttonEnter.showProgress(false);

                TextInputLayout inputLayoutTest = findViewById(R.id.login_edit_text_email_input);
                inputLayoutTest.setError("Esse email é inválido");
                editTextEmail.setBackground(ContextCompat.getDrawable(LoginActivity.this,
                        R.drawable.edit_text_background_error));


                TextInputLayout inputLayoutTestP = findViewById(R.id.login_edit_text_password_input);
                inputLayoutTestP.setError("Essa senha é inválido");
                editTextPassword.setBackground(ContextCompat.getDrawable(LoginActivity.this,
                        R.drawable.edit_text_background_error));

            }, 4000);
        });







    }

    //watcher escuta os eventos de input em um editor de texto
    // referencia para text watcher instanciado
    private TextWatcher watcher = new TextWatcher() {
        //watcher é uma interface precisa implementar
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //se a string recebida na campo de texto não for vazia -> ativar o botão
            if (!charSequence.toString().isEmpty())
                findViewById(R.id.login_button_enter).setEnabled(true);
                //se não desativar o botão
            else
                findViewById(R.id.login_button_enter).setEnabled(false);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}