package com.example.hadrizia.projetoandroidstudyjams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botao_filme_1 = (ImageButton) findViewById(R.id.filme1);
        ImageButton botao_filme_2 = (ImageButton) findViewById(R.id.filme2);
        ImageButton botao_filme_3 = (ImageButton) findViewById(R.id.filme3);
        ImageButton botao_filme_4 = (ImageButton) findViewById(R.id.filme4);

        botao_filme_1.setOnClickListener(this);
        botao_filme_2.setOnClickListener(this);
        botao_filme_3.setOnClickListener(this);
        botao_filme_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Filme filme = null;
        int id = view.getId();
        switch(id)
        {
            case R.id.filme1:
                filme = new Filme("1",
                        "Love, rosie",
                        "@drawable/rosie",
                        "2014",
                        "1h 42min",
                        "7.2",
                        false,
                        "Rosie and Alex have been best friends since they were 5, " +
                                "so they couldn't possibly be right for one another...or could they? " +
                                "When it comes to love, life and making the right choices, " +
                                "these two are their own worst enemies.",
                        "https://www.youtube.com/watch?v=5zL3YJKygd4",
                        "https://www.youtube.com/watch?v=topL5BSL2bI"
                        );
                break;

            case R.id.filme2:
                filme = new Filme("2",
                        "One day",
                        "@drawable/filme2",
                        "2011",
                        "1h 47min",
                        "7.0",
                        false,
                        "After spending the night together on the night of their college graduation " +
                                "Dexter and Em are shown each year on the same date to see where they " +
                                "are in their lives. They are sometimes together, sometimes not, " +
                                "on that day.",
                        "https://www.youtube.com/watch?v=zVuuooZqVaU",
                        "https://www.youtube.com/watch?v=3C1dSEK27L0"
                        );
                break;

            case R.id.filme3:
                filme = new Filme("3",
                        "Mockingjay - Part 2",
                        "@drawable/jogos",
                        "2015",
                        "2h 17min",
                        "6.7",
                        false,
                        "As the war of Panem escalates to the destruction of other districts, " +
                                "Katniss Everdeen, the reluctant leader of the rebellion, must " +
                                "bring together an army against President Snow, while all she " +
                                "holds dear hangs in the balance.",
                        "https://www.youtube.com/watch?v=n-7K_OjsDCQ",
                        "https://www.youtube.com/watch?v=eyt4xRQsbfI"
                        );
                break;

            case R.id.filme4:
                filme = new Filme("4",
                        "Her",
                        "@drawable/filme4",
                        "2013",
                        "2h 6min",
                        "8.0",
                        false,
                        "A lonely writer develops an unlikely relationship with his newly " +
                                "purchased operating system that's designed to meet his every need.",
                        "https://www.youtube.com/watch?v=WzV6mXIOVl4",
                        "https://www.youtube.com/watch?v=hX09Kz7BAlU"
                        );
                break;

            default:
                break;
        }

        Intent nextActivity = new Intent(MainActivity.this, Main2Activity.class);
        nextActivity.putExtra("filme", filme);
        startActivity(nextActivity);
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
