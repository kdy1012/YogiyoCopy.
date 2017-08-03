package kr.co.tjeit.yogiyocopy;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.yogiyocopy.adapter.StoreAdapter;
import kr.co.tjeit.yogiyocopy.data.StoreData;

public class MainActivity extends TabActivity {

    TabHost myTabHost;

    private ListView storeListView;
    List<StoreData> storeDataList = new ArrayList<>();
    StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTabHost = getTabHost();
        storeListView = (ListView) findViewById(R.id.storeListView);

        TabHost.TabSpec spec1 = myTabHost.newTabSpec("tab1").setIndicator("가게목록");
        spec1.setContent(R.id.tab1);
        myTabHost.addTab(spec1);


        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab2").setIndicator("주문내역");
        spec2.setContent(R.id.tab2);
        myTabHost.addTab(spec2);

        TabHost.TabSpec spec3 = myTabHost.newTabSpec("tab3").setIndicator("더보기");
        spec3.setContent(R.id.tab3);
        myTabHost.addTab(spec3);



        storeDataList.add(new StoreData("교촌치킨-대학로점", 4.2f, 1200, 2330, 15000, true));
        storeDataList.add(new StoreData("원할머니보쌈-종로5가점", 3.8f, 1100, 300, 25000, false));

        storeAdapter = new StoreAdapter(MainActivity.this, storeDataList);
        storeListView.setAdapter(storeAdapter);

    }
}






