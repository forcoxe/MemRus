package com.example.memrus;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.memrus.dal.ContainerDAL;
import com.example.memrus.dto.Container;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Button button;
    private Button buttonCustom;
    private ContainerDAL containerDAL;
    private ListView listSeries;
    private ArrayAdapter<Container> adapter;
    private ArrayList<Container> listaSeries;
    private int codPosicion = 0;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();


        //Creación del container

        //BOORRRAT LA BASE DE DATOS
       // getApplicationContext().deleteDatabase("memrus.db");


        this.containerDAL = new ContainerDAL(getApplicationContext(),new Container());
        this.listaSeries = new ContainerDAL(getBaseContext()).seleccionar();



        this.searchView = (SearchView) findViewById(R.id.av_location);



       this.searchView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Log.w("NO,","FUNCA");
               openActivitySearch();
           }
       });


        /*

        // Sólo para construir el mensaje de diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirmación");
        builder.setMessage("¿Desea borrar la serie?");
        builder.setPositiveButton("Si, borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = ((Container) listaSeries.get(codPosicion)).getId();
                boolean r = containerDAL.eliminar(id);
                if(r){
                    Toast.makeText(getApplicationContext(), "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
                    actualizarLista();
                } else {
                    Toast.makeText(getApplicationContext(), "No se ha podido eliminar la serie", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        final AlertDialog dialog = builder.create();

        // Tap presionado por un tiempo
        listSeries.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                dialog.show();
                return true;
            }
        });

        // Tap simple
        listSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirEditarSerieActivity();
            }
        });

         */


        button = (Button) findViewById(R.id.bt1);
        buttonCustom = (Button) findViewById(R.id.bt);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        */

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySlider();
            }
        });
        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySlider2();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void openActivitySlider(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void openActivitySlider2(){
        Intent intent = new Intent(this, CustomContainers.class);
        startActivity(intent);
    }
    public void openActivitySearch(){

        Intent intent = new Intent(this, SearchWord.class);

        String w = this.searchView.getQuery().toString();
        intent.putExtra("search", w);

        startActivityForResult(intent, 100);
    }

    private void abrirEditarSerieActivity() {
        Intent intento = new Intent(MainActivity.this, Main2Activity.class);
        Container s = (Container) listaSeries.get(codPosicion);

        intento.putExtra("container", s);


        startActivityForResult(intento, 100);
    }

    private void actualizarLista() {

        adapter.clear();
        adapter.addAll(containerDAL.seleccionar());
        adapter.notifyDataSetChanged();
    }


}
