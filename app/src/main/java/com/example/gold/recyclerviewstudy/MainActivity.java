package com.example.gold.recyclerviewstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;
    List<ListData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = makeDatas();

        //ListAdapter adapter = new ListAdapter(this, makeIntDatas(100));

        ListAdapter adapter = new ListAdapter(this, data);
        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.hasFixedSize();
//        list.addItemDecoration(new MyDecoration());
//        list.addItemDecoration(new MyDecoration2());
        list.addItemDecoration(new ComplexDecoration(this, new Callback() {
            @Override
            public long getGroupId(int position) {
                return Character.toUpperCase(data.get(position).title.charAt(0));
            }

            @Override
            public String getGroupFirstLine(int position) {
                return data.get(position).title.substring(0, 1).toUpperCase();
            }
        }));
        list.setAdapter(adapter);

    }

    public int[] makeIntDatas(int howMany) {
        int[] datas = new int[howMany];
        for (int i = 0; i<howMany; i++) {
            datas[i] = i;
        }
        return datas;
    }

    public List<ListData> makeDatas() {
        return ListData.createListDataListSorted();
    }
}
