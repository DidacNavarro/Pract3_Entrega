package cat.urv.deim.asm.p3.shared;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cat.urv.deim.asm.libraries.commanagerdc.providers.DataProvider;
import cat.urv.deim.asm.p2.common.R;

public class Faqs extends AppCompatActivity {

    private static final String TAG = Faqs.class.getSimpleName();


    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> listaPreguntas;
    HashMap<String, List<String>> listaRespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        getSupportActionBar().setTitle("FAQS");



        expandableListView = findViewById(R.id.eListView);
        showList();

        listViewAdapter = new ExpandableListViewAdapter(this, listaPreguntas, listaRespuestas);
        expandableListView.setAdapter(listViewAdapter);
    }

    private void showList() {
        listaPreguntas = new ArrayList<String>();
        listaRespuestas = new HashMap<String, List<String>>();

        listaPreguntas.add("Pregunta 1");
        listaPreguntas.add("Pregunta 2");
        listaPreguntas.add("Pregunta 3");
        listaPreguntas.add("Pregunta 4");

        List<String> topic1 = new ArrayList<>();
        topic1.add("respuesta 1");


        List<String> topic2 = new ArrayList<>();
        topic2.add("respuesta 2");


        List<String> topic3 = new ArrayList<>();
        topic3.add("respuesta3");


        List<String> topic4 = new ArrayList<>();
        topic4.add("respuesta4");


        listaRespuestas.put(listaPreguntas.get(0), topic1);
        listaRespuestas.put(listaPreguntas.get(1), topic2);
        listaRespuestas.put(listaPreguntas.get(2), topic3);
        listaRespuestas.put(listaPreguntas.get(3), topic4);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.nav_news){
            finish();
        }

        return super.onOptionsItemSelected(menuItem);
    }

}


