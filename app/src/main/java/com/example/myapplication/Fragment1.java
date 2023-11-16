package com.example.myapplication;
 import android.annotation.SuppressLint;
 import android.content.Context;
 import android.content.Intent;
 import android.os.Bundle;
 import androidx.fragment.app.Fragment;
 import androidx.recyclerview.widget.DividerItemDecoration;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;

 import java.util.ArrayList;
 import java.util.List;
public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    Myadapter adapter;
    List<String> list;
    Context context;

    //    @Override
    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.fragment1);
        list = new ArrayList<String>();
        initData();
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new Myadapter(context, list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        //点击事件
        adapter.setOnItemClickListening(new Myadapter.OnItemClickListening() {
            @Override
            public void onClickItem(List<String> list1) {
                Intent intent=new Intent(requireContext(), IntentActivity.class);
                startActivity(intent);
            }
        });
        return view;


    }

    private void initData() {
        list.add("斗罗大陆");
        list.add("斗破苍穹");
        list.add("大主宰");
        list.add("一念永恒");
        list.add("庆余年");
        list.add("偷星九月天");
        list.add("极度分裂");
}


}