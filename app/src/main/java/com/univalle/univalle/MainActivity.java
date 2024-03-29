package com.univalle.univalle;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static String TAG = MainActivity.class.getSimpleName();

    private String nombreCarpeta = "univalleA";



    void leerArchivo() {
        File fileDocuments = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File miCarpeta = new File(fileDocuments.getAbsolutePath(), nombreCarpeta);
        File miArchivo = new File(miCarpeta.getAbsolutePath(), "A.txt");

        String text = "";
        try {
            String line;
            BufferedReader br =
                    new BufferedReader(new FileReader(miArchivo));
            while ((line = br.readLine()) != null) {
                text  += line;
            }
            br.close();
        } catch (IOException e) {
        }

        Log.d(TAG, "---->" + text);
    }



    void testPreferencias() {
        SharedPreferences sp = getSharedPreferences("emilio",
                Context.MODE_PRIVATE);

        // Guardar
        sp.edit().putString("nombre","univalle").commit();
        sp.edit().putBoolean("activo",false).commit();
        sp.edit().putInt("edad",20).commit();

        // Obtener
        int edad = sp.getInt("edad",-1);
        String nombre= sp.getString("nombre","--");
    }

    void crearCarpeta() {
        File fileDocuments = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File miCarpeta = new File(fileDocuments.getAbsolutePath(), nombreCarpeta);
        miCarpeta.mkdir();

        //new File()
        Log.d(TAG, "-->" + fileDocuments.getAbsolutePath());
    }

    void crearArchivo() {
        File fileDocuments = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File miCarpeta = new File(fileDocuments.getAbsolutePath(), nombreCarpeta);
        File miArchivo = new File(miCarpeta.getAbsolutePath(), "A.txt");

        String texto = "Emilio";

        try {
            FileOutputStream ous = new FileOutputStream(miArchivo);
            ous.write(texto.getBytes());
            ous.close();
            Toast.makeText(this, "Archivo creado", Toast.LENGTH_SHORT)
                    .show();
        } catch (Exception e) {
            Toast.makeText(this, "Archivo no creado", Toast.LENGTH_SHORT)
                    .show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, 43
            );
        }


        crearCarpeta();
        crearArchivo();
        testPreferencias();
        leerArchivo();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
