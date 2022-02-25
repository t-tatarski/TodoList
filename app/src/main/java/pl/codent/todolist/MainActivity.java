package pl.codent.todolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static CustomAdapter adapter;
    public static List<Doctor> doctors;
    public static final String STOREDDAT = "storedData";
    public static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        doctors = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean firstRun = preferences.getBoolean("prefFirstRun", true);
        if (!firstRun) {
             sp = getSharedPreferences("app",MODE_PRIVATE);
            String entryName1 = sp.getString("entryN1", "");
            String entryName2 = sp.getString("entryN2", "");
            String entryName3 = sp.getString("entryN3", "");
            String entryName4 = sp.getString("entryN4", "");
            String entryName5 = sp.getString("entryN5", "");
            String entryName6 = sp.getString("entryN6", "");
            doctors.add(new Doctor(entryName1.toString(), false));
            doctors.add(new Doctor(entryName2.toString(), false));
            doctors.add(new Doctor(entryName3.toString(), false));
            doctors.add(new Doctor(entryName4.toString(), false));
            doctors.add(new Doctor(entryName5.toString(), false));
            doctors.add(new Doctor(entryName6.toString(), false));
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