package co.edu.unipiloto.pizzas;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

//import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
//import android.support.v7.widget.Toolbar;

//import android.support.v4.view.MenuItemCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ShareActionProvider shareActionProvider;

    private EditText name,race,weight,age;
    private ImageView addT, backT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addT = findViewById(R.id.add);
        ImageView backT = findViewById(R.id.back);
        name = findViewById(R.id.name);
        race = findViewById(R.id.race);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);
        addT = findViewById(R.id.add);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backT.setVisibility(View.GONE);
        //addT.setVisibility(View.GONE);
        addT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                name.setText("");
                race.setText("");
                weight.setText("");
                age.setText("");
            }
        });
    }

    public void submit(View view) {
        String nameStr = name.getText().toString();
        String raceStr = race.getText().toString();
        String weightStr = weight.getText().toString();
        String ageStr = age.getText().toString();
        sharedPreferences = getSharedPreferences("petin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Toast.makeText(this,nameStr,Toast.LENGTH_SHORT).show();
        editor.putString("name", nameStr);
        editor.putString("race", raceStr);
        editor.putString("weight", weightStr);
        editor.putString("age", ageStr);
        editor.apply();
        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join to HappyPaws?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (shareActionProvider != null) {
            shareActionProvider.setShareIntent(intent);
        }
    }

}