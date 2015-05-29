package com.example.lacuna.geomanual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ListView lv1;
    private ViewPager viewPager;


    String[] data = new String[]{"Края","Автономные округа", "Республики", "Автономная область"};



    //Создаем массив разделов:
    private String lv_arr[]={
            "01. Алтайский край (Барнаул)",
            "02. Камчатский край (Петропавловск-Камчатский)",
            "03. Хабаровский край (Хабаровск)",
            "04. Краснодарский край (Краснодар)",
            "05. Красноярский край (Красноярск)",
            "06. Пермский край (Пермь)",
            "07. Приморский край (Владивосток)",
            "08. Ставропольский край (Ставрополь)",
            "09. Забайкальский край (Чита)",
    };



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");


        final ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar.setListNavigationCallbacks(adapter, this);


        // Получим идентификатор ListView
        lv1 = (ListView)findViewById(R.id.listView);
        //устанавливаем массив в ListView
        lv1.setAdapter(
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
        lv1.setTextFilterEnabled(true);
        //Обрабатываем щелчки на элементах ListView:
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
                //Позиция элемента, по которому щелкнули
                String itemname = new Integer(position).toString();

                Intent intent = new Intent();

                intent.setClass(MainActivity.this, DetailActivity.class);

                Bundle b = new Bundle();

                //defStrID содержит строку, которую отправим через itemname в другое Activity
                b.putString("defStrID", itemname);

                intent.putExtras(b);

                //запускаем Intent
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //меню настроек
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); //xml файл
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//пункты меню
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();//получаем модификатор

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));//явный интент
            return true;
        }
        if (id == R.id.action_email) {
            startActivity(new Intent(this, EmailActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Log.d(LOG_TAG, "selected: position = " + itemPosition + ", id = "
                + itemId + ", " + data[itemPosition]);
        viewPager.setCurrentItem(itemPosition, true);
        return false;
    }

}
