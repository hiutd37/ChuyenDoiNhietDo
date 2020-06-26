package com.example.chuyendoinhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chuyendoinhietdo.Fragment.DoiCquaF;
import com.example.chuyendoinhietdo.Fragment.DoiFquaC;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    EditText edtC1;
    EditText edtF1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiFragment();
}

    private void events() {

    }

    public void xuLyChuyenForm(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnFormDoiCquaF:
                fragment = new DoiCquaF();
                break;
            case R.id.btnFormDoiFQuaC:
                fragment = new DoiFquaC();
                break;
        }
        fragmentTransaction.replace(R.id.frmContent, fragment);
        fragmentTransaction.commit();
    }
    private void intiFragment() {
        DoiCquaF doiCquaF = new DoiCquaF();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frmContent, doiCquaF);
        fragmentTransaction.commit();
    }

    public void doiNhietDoCF(View view) {
        edtC1 = findViewById(R.id.edtC1);
        edtF1 = findViewById(R.id.edtF1);

        edtC1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtF1.setText("");
            }
        });

        if (Pattern.matches("(^\\d+$)|(^-\\d+$)", edtC1.getText().toString())){
            double c1 = Double.parseDouble(edtC1.getText().toString());
            double f1 = c1*1.8+32;
            edtF1.setText(Double.toString(f1));
        }
        else {
            Toast.makeText(this, "Vui lòng nhập gia trị!", Toast.LENGTH_SHORT).show();
        }
    }

    public void doiNhietDoFC(View view) {
        edtC1 = findViewById(R.id.edtC);
        edtF1 = findViewById(R.id.edtF);

        edtF1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtC1.setText("");
            }
        });

        if (Pattern.matches("(^\\d+$)|(^-\\d+$)", edtF1.getText().toString())){
            double f1 = Double.parseDouble(edtF1.getText().toString());
            double c1 = (f1-32)/1.8;
            edtC1.setText(Double.toString(c1));
        }
        else {
            Toast.makeText(this, "Vui lòng nhập giá trị!", Toast.LENGTH_SHORT).show();
        }
    }
}

