package co.edu.unipiloto.pizzas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);

        TextView name = findViewById(R.id.name);
        TextView race = findViewById(R.id.race);
        TextView weight = findViewById(R.id.weight);
        TextView age = findViewById(R.id.age);

        SharedPreferences preferences = getSharedPreferences("petin", MODE_PRIVATE);

        String n = preferences.getString("name","");
        Toast.makeText(this,n,Toast.LENGTH_SHORT).show();
        name.setText("nombre : " + preferences.getString("name",""));
        race.setText("raza : " +preferences.getString("race",""));
        weight.setText("weight : " + preferences.getString("weight",""));
        age.setText("age : " + preferences.getString("age",""));
    }
}