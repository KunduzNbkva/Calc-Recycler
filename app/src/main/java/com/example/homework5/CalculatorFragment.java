package com.example.homework5;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {
    TextView textView;
    Double firstArg;
    Double secondArg;
    Double result;
    String operation;
    String results;
    Button first, two, three, four, five, six, seven, eight, nine, zero, plus, minus, divide, multiply, equal, dot, clear;
    OnCLickFragment listener;
    ArrayList<String> list=new ArrayList<>();
    String resultToArray;



    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment create(OnCLickFragment listener) {
        CalculatorFragment fragment = new CalculatorFragment();
        fragment.listener = listener;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
        // Inflate the layout for this fragment
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView);
        first = view.findViewById(R.id.one);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("1");
            }
        });
        two = view.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("2");
            }
        });
        three = view.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("3");
            }
        });
        four = view.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("4");
            }
        });
        five = view.findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("5");
            }
        });
        six = view.findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("6");
            }
        });
        seven = view.findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("7");
            }
        });
        eight = view.findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("8");
            }
        });
        nine = view.findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("9");
            }
        });
        zero = view.findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("0");
            }
        });
        plus = view.findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "+";
                firstArg = Double.valueOf(textView.getText().toString());
                textView.setText(firstArg + "+");
            }
        });
        minus = view.findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "-";
                firstArg = Double.valueOf(textView.getText().toString());
                textView.setText(firstArg + "-");
            }
        });
        divide = view.findViewById(R.id.division);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "/";
                firstArg = Double.valueOf(textView.getText().toString());
                textView.setText(firstArg + "/");
            }
        });
        multiply = view.findViewById(R.id.multiplication);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "*";
                firstArg = Double.valueOf(textView.getText().toString());
                textView.setText(firstArg + "*");
            }
        });
        equal = view.findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (operation != null) {
                    String second = textView.getText().toString().replace(firstArg + operation + "", "");
                    secondArg = Double.valueOf(second);
                    switch (operation) {

                        case "+":
                            result = firstArg + secondArg;
                            results = firstArg + "+" + secondArg + "=" + result;
                            textView.setText(results);
                           resultToArray = textView.getText().toString();
                           list.add(resultToArray);
                           listener.OnCLickChange(list);
                            break;
                        case "-":
                            result = firstArg - secondArg;
                            textView.setText(firstArg + "-" + secondArg + "=" + result);
                           results = textView.getText().toString();
                            list.add(results);
                            listener.OnCLickChange(list);

                            break;
                        case "/":
                            result = firstArg / secondArg;
                            textView.setText(firstArg + "/" + secondArg + "=" + result);
                          results = textView.getText().toString();
                          list.add(results);
                            listener.OnCLickChange(list);
                            break;
                        case "*":
                            result = firstArg + secondArg;
                            textView.setText(firstArg + "*" + secondArg + "=" + result);
                             results = textView.getText().toString();
                             list.add(results);
                            listener.OnCLickChange(list);
                            break;
                    }

                }
            }
        });
        clear = view.findViewById(R.id.clean);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
        dot = view.findViewById(R.id.point);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView != null && textView.length() > 0) {
                    textView.append(".");
                } else {
                    {
                        textView.setText("");
                    }
                }
            }
        });

    }
}
