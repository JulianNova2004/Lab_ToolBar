package co.edu.unipiloto.pizzas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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

        ImageView back = findViewById(R.id.back);
        ImageView add = findViewById(R.id.add);
        //ImageView send = findViewById(R.id.send);
        TextView name = findViewById(R.id.name);
        TextView race = findViewById(R.id.race);
        TextView weight = findViewById(R.id.weight);
        TextView age = findViewById(R.id.age);

        back.setVisibility(View.VISIBLE);
        add.setVisibility(View.GONE);
        //send.setVisibility(View.GONE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = getSharedPreferences("petin", MODE_PRIVATE);

        String n = preferences.getString("name","");
        Toast.makeText(this,n,Toast.LENGTH_SHORT).show();
        name.setText("Nombre : " + preferences.getString("name",""));
        race.setText("Raza : " +preferences.getString("race",""));
        weight.setText("Weight : " + preferences.getString("weight",""));
        age.setText("Age : " + preferences.getString("age",""));
    }
}