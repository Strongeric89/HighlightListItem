package com.example.eric.customadapterlist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv = null;
    private static int lastClickId = -1;

    public static String countries[] = {"USA","Russia","Poland","Ireland","UK","Germany","France","Italy","Spain", "Portugal"};
    public static Integer images[] = {
            R.drawable.one,
            R.drawable.two
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.tasklist);

        CustomAdapter adapter = new CustomAdapter(this, countries, images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"you selected: " + countries[i], Toast.LENGTH_SHORT).show();


                if ((lastClickId != -1) && (lastClickId != i)) {
                    parent.getChildAt(lastClickId).setBackgroundResource(
                            R.color.white);

                    view.setBackgroundResource(R.color.grey);
                }
                if (lastClickId == -1) {
                    view.setBackgroundResource(R.color.grey);
                }
                lastClickId = i;




            }
        });
    }
}
