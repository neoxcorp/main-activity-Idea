package com.idea.mainactivityidea;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    int[] image_ids = { R.drawable.icon172, R.drawable.icon272, R.drawable.icon372,
            R.drawable.icon472, R.drawable.icon572, R.drawable.icon672 };
    String[] device_list = { "Table Lamp", "Geyzer", "MicrowaveOwen", "Refrigerator", "Televison",
            "Personal Computer"};
    ListView devices_list;

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
        devices_list=(ListView)findViewById(R.id.Devices_list);

        Devices_adapter adapter=new Devices_adapter(this,image_ids,device_list);
        devices_list.setAdapter(adapter);

    }

}
