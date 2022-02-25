package pl.codent.todolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Activity2 extends AppCompatActivity {
    private ImageView iv_mic;
    private TextView tv_Speech_to_text;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private Button btndone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        iv_mic = findViewById(R.id.micBtn);
        tv_Speech_to_text = findViewById(R.id.textViewSTT);


        iv_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent
                        = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                        Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");

                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), " " + e.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                tv_Speech_to_text.setText(
                        Objects.requireNonNull(result).get(0));
                MainActivity.doctors.add(new Doctor(result.get(0).toUpperCase(Locale.ROOT),false));
                SharedPreferences sp=getSharedPreferences("app",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("entryN1",result.get(0));
                editor.apply();
                MainActivity.adapter.notifyDataSetChanged();


            }
        }
    }
}