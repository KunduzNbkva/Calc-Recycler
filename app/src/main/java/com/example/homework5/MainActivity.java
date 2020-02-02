package com.example.homework5;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnCLickFragment,OnCLickBack{
    CalculatorFragment calculatorFragment=CalculatorFragment.create(this);
    ListFragment listFragment=ListFragment.create(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(calculatorFragment);

    }
    public void changeFragment( Fragment fragment){
        FragmentManager manager=getSupportFragmentManager(); //Достаем существующий фрагмент именно сапорт реализует обратную совместимость
        FragmentTransaction transaction=manager.beginTransaction();// будет менять фрагменты
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override
    public void OnCLickChange(ArrayList<String> s) {
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("key",s);
        listFragment.setArguments(bundle);
        changeFragment(listFragment);


    }

    @Override
    public void backToCalc() {
        changeFragment(calculatorFragment);

    }
}
