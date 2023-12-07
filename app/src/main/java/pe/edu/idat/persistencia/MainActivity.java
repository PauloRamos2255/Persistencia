package pe.edu.idat.persistencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TextView fullname;
    TextView balance;
    FloatingActionButton goToSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullname = findViewById(R.id.fullname);
        balance = findViewById(R.id.balance);
        goToSettings = findViewById(R.id.goToSettings);

        goToSettings.setOnClickListener( view -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean hideBalance = sharedPreferences.getBoolean("hideBalance", false);
        balance.setText(hideBalance ? "S/ ***.**": "S/ 700.00");

    }


}