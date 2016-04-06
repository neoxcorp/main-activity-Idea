package com.idea.mainactivityidea;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        devices_list = (ListView)findViewById(R.id.Devices_list);

        Devices_adapter adapter = new Devices_adapter(this, image_ids, device_list);
        devices_list.setAdapter(adapter);

        devices_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
                devices_list.setSelection(position);
                devices_list.setItemChecked(position, true);
                view.setEnabled(true);
                view.setSelected(true);
            }
        });

        init();
    }

    @SuppressWarnings("ConstantConditions")
    private void init() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView titleSplashTv = (TextView) findViewById(R.id.titleTv);
        titleSplashTv.setText(titleSplashTv.getText().toString().toUpperCase());
        titleSplashTv.setTypeface(BaseApplication.getTypeFaceTitle());

        // buttons
        findViewById(R.id.settingsImBtn).setOnClickListener(this);
        findViewById(R.id.fab).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingsImBtn:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab:
                Snackbar.make(v, "Add", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
        }
    }
}
