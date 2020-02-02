package com.example.homework5;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    MainAdapter adapter;

    Button back;
    OnCLickBack listenerList;
    ArrayList<String> lisst=new ArrayList<>();

    public static ListFragment create(OnCLickBack listener) {
        ListFragment fragment = new ListFragment();
        fragment.listenerList = listener;
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    private String res;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            res = savedInstanceState.getString("key");
        }
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (adapter == null){
            adapter = new MainAdapter();
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        back=view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerList.backToCalc();

            }
        });
        Bundle bundle =getArguments();
        if (bundle != null) {
            lisst=bundle.getStringArrayList("key");
            adapter.update(lisst);
        }
    }


}
