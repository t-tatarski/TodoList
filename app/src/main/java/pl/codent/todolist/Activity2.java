package pl.codent.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class Activity2 extends AppCompatActivity {
    public static final Integer RecordAudioRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}