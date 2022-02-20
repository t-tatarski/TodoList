package pl.codent.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean firstRunApp = preferences.getBoolean("firstrun",true);
        if (!firstRunApp) {showToast("witaj pierwszy raz");
        }else{
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstrun",true);
        editor.commit();
        showToast("witaj nie pierwszy raz");
        }

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String msgText) {
        Toast.makeText(getApplicationContext(),msgText,Toast.LENGTH_LONG).show();
    }

}