package com.example.integragor3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private AdapterList adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> model = new ArrayList<>();

        Item i = new Item();
        i.setEstrella(4);
        i.setImagen(R.drawable.uno);
        model.add(i);


        i = new Item();
        i.setEstrella(2);
        i.setImagen(R.drawable.tres);
        model.add(i);

        i = new Item();
        i.setEstrella(5);
        i.setImagen(R.drawable.cinco);
        model.add(i);

        i = new Item();
        i.setEstrella(3);
        i.setImagen(R.drawable.cuatro);
        model.add(i);

        i = new Item();
        i.setEstrella(1);
        i.setImagen(R.drawable.dos);
        model.add(i);

        adapter =new AdapterList(this, model);


        lista =(ListView)findViewById(R.id.milista);
        lista.setAdapter(adapter);

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Item item=(Item) adapter.getItem(position);
                    Log.e("item",item.getImagen()+"-"+item.getEstrella());
                    Toast.makeText(getBaseContext(),"Tu imagen es:"+item.getImagen(),Toast.LENGTH_LONG).show();

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


    }

/*private void cargarDatos(){
        lista.add(new Item(R.drawable.uno,3));
        lista.add(new Item(R.drawable.dos,4));
        lista.add(new Item(R.drawable.tres,2));
        lista.add(new Item(R.drawable.cuatro,5));
        lista.add(new Item(R.drawable.cinco,1));

}
private void generaVista(){
    ArrayAdapter<Item> adapter = new AdapterList();
    ListView lv=(ListView)findViewById(R.id.milista);
    lv.setAdapter(adapter);
}*/
}
