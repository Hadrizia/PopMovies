package com.example.hadrizia.projetoandroidstudyjams;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Main2Activity extends Activity{
    static final String PREFS_NAME = "Preferences";
    private  Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        filme = (Filme) intent.getSerializableExtra("filme");

        createScreen(filme);

    }

    private void createScreen(final Filme filme) {
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(filme.getTitulo());

        TextView ano = (TextView) findViewById(R.id.ano);
        ano.setText(filme.getAno());

        TextView duracao = (TextView) findViewById(R.id.duracao);
        duracao.setText(filme.getDuracao());

        TextView nota = (TextView) findViewById(R.id.nota);
        nota.setText(filme.getNota() + "/10");

        TextView descricao = (TextView) findViewById(R.id.descricao);
        descricao.setText(filme.getDescricao());

        ImageView poster = (ImageView) findViewById(R.id.poster);
        String uri = filme.getEndereco_poster();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        poster.setImageDrawable(res);

        CheckBox favorito = (CheckBox) findViewById(R.id.favorito);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        favorito.setChecked(settings.getBoolean(filme.getId(), filme.isFavorito()));

        ImageButton b1 = (ImageButton) findViewById(R.id.imageButton);
        ImageButton b2 = (ImageButton) findViewById(R.id.imageButton2);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filme.getEndereco_trailer1()));
                startActivity(browserIntent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filme.getEndereco_trailer2()));
                startActivity(browserIntent);
            }
        });
        }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    protected void onStop(){
        super.onStop();

        CheckBox favorito = (CheckBox)findViewById(R.id.favorito);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        if (favorito.isChecked()) {
            filme.setFavorito(true);
            editor.putBoolean(filme.getId(), filme.isFavorito());
        }else{
            filme.setFavorito(false);
            editor.putBoolean(filme.getId(), filme.isFavorito());
        }

        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
