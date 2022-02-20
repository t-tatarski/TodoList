package pl.codent.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static CustomAdapter adapter;
    public static List<Doctor> doctors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        doctors = new ArrayList<>();

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

        RecyclerView recyclerView = findViewById(R.id.recyclervw);
         adapter = new CustomAdapter(doctors);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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