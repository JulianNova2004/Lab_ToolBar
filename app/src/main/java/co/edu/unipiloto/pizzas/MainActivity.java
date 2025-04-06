package co.edu.unipiloto.pizzas;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//import android.support.v7.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private EditText name,race,weight,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView add = findViewById(R.id.add);
         name = findViewById(R.id.name);
         race = findViewById(R.id.race);
         weight = findViewById(R.id.weight);
         age = findViewById(R.id.age);



        //add.setVisibility(View.GONE);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    public void sub(View view) {
        String nameStr = name.getText().toString();
        String raceStr = race.getText().toString();
        String weightStr = weight.getText().toString();
        String ageStr = age.getText().toString();
        sharedPreferences = getSharedPreferences("petin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Toast.makeText(this,nameStr,Toast.LENGTH_SHORT).show();
        editor.putString("name", nameStr);
        editor.putString("race", raceStr);
        editor.putString("weight", weightStr);
        editor.putString("age", ageStr);
        editor.apply();
        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();


    }
}