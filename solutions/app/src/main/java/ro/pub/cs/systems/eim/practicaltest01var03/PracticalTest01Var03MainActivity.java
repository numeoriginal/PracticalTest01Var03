package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {


    private EditText fst_line;
    private EditText snd_line;
    private Button plus_btn;
    private Button minus_btn;
    private TextView result;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            int res;
            String aux = "Result: ";

            switch (view.getId()) {
                case R.id.btnMinus:
                        res = Integer.parseInt(fst_line.getText().toString()) +
                                Integer.parseInt(snd_line.getText().toString());
                        aux += fst_line.getText().toString();
                        aux += " + ";
                        aux += snd_line.getText().toString();
                        aux += " = ";
                        aux += String.valueOf(res);

                        result.setText(aux);
                    break;
                case R.id.btnPlus:
                        res = Integer.parseInt(fst_line.getText().toString()) -
                                Integer.parseInt(snd_line.getText().toString());
                        aux += fst_line.getText().toString();
                        aux += " - ";
                        aux += snd_line.getText().toString();
                        aux += " = ";
                        aux += String.valueOf(res);
                        result.setText(aux);
                    break;

                case R.id.navigate:

                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        plus_btn = findViewById(R.id.btnPlus);
        plus_btn.setOnClickListener(buttonClickListener);

        minus_btn = findViewById(R.id.btnMinus);
        minus_btn.setOnClickListener(buttonClickListener);
        fst_line = findViewById(R.id.ed_fst_line);
        snd_line = findViewById(R.id.ed_snd_line);
        result = findViewById(R.id.result_field);

        if (savedInstanceState != null) {

            if (savedInstanceState.containsKey("FST_LINE")) {
                fst_line = findViewById(R.id.ed_fst_line);
                fst_line.setText(savedInstanceState.getString("FST_LINE"));
            }
            if (savedInstanceState.containsKey("SND_LINE")) {
                snd_line = findViewById(R.id.ed_snd_line);
                snd_line.setText(savedInstanceState.getString("SND_LINE"));
            }
            if (savedInstanceState.containsKey("TEXT")) {
                result = findViewById(R.id.result_field);
                result.setText(savedInstanceState.getString("TEXT"));
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
            fst_line = findViewById(R.id.ed_fst_line);
            snd_line = findViewById(R.id.ed_snd_line);
            result = findViewById(R.id.result_field);
            savedInstanceState.putString("FST_LINE", fst_line.getText().toString());
            savedInstanceState.putString("SND_LINE", snd_line.getText().toString());
            savedInstanceState.putString("TEXT", result.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("FST_LINE")) {
            fst_line = findViewById(R.id.ed_fst_line);
            fst_line.setText(savedInstanceState.getString("FST_LINE"));
            Toast.makeText(this, fst_line.getText().toString(), Toast.LENGTH_LONG).show();
        }
        if (savedInstanceState.containsKey("SND_LINE")) {
            snd_line = findViewById(R.id.ed_snd_line);
            snd_line.setText(savedInstanceState.getString("SND_LINE"));
            Toast.makeText(this, snd_line.getText().toString(), Toast.LENGTH_LONG).show();
        }
        if (savedInstanceState.containsKey("TEXT")) {
            result = findViewById(R.id.result_field);
            Toast.makeText(this, result.getText().toString(), Toast.LENGTH_LONG).show();
            result.setText(savedInstanceState.getString("TEXT"));
        }
    }

}