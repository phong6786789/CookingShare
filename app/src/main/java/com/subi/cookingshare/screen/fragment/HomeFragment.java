package com.subi.cookingshare.screen.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.subi.cookingshare.R;
import com.subi.cookingshare.data.adapter.HomeAdapter;
import com.subi.cookingshare.data.adapter.TypeAdapter;
import com.subi.cookingshare.data.model.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view = null;
    private ImageView iv_add_food, ivWay1, ivWay2, ivWay3, ivWay4, ivWay5;
    private TextView tvWay1, tvWay2, tvWay3, tvWay4, tvWay5;
    private LinearLayout ln1, ln2, ln3, ln4, ln5;
    private Dialog dialog;
    private Spinner spWays;
    private RecyclerView rcv_type;
    private TypeAdapter typeAdapter;
    private ArrayList<String> list = new ArrayList<>();
    private RecyclerView rcv_food;

    private HomeAdapter homeAdapter;
    private ArrayList<Food> listFood = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();

        //add list
        list.add("Thịt heo");
        list.add("Thịt bò");
        list.add("Gà");
        list.add("Trứng");
        list.add("Vịt");
        list.add("Món chay");

        //add list food
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.a, "Loại dinh dưỡng"));
        listFood.add(new Food("1", "Bò beef steak", R.drawable.b, "Thịt loại 1"));
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.c, "Loại dinh dưỡng"));
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.d, "Loại dinh dưỡng"));
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.e, "Loại dinh dưỡng"));
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.h, "Loại dinh dưỡng"));
        listFood.add(new Food("1", "Pizza trái cây", R.drawable.j, "Loại dinh dưỡng"));


        //RCV type
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcv_type.setLayoutManager(layoutManager);
        typeAdapter = new TypeAdapter(getActivity(), list);
        rcv_type.setAdapter(typeAdapter);

        //RCV food
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        rcv_food.setLayoutManager(layoutManager2);
        homeAdapter = new HomeAdapter(getActivity(), listFood);
        rcv_food.setAdapter(homeAdapter);
        setOnClickItem();
        return view;
    }


    private void init() {
        iv_add_food = view.findViewById(R.id.iv_add_food);
        spWays = view.findViewById(R.id.spWays);
        rcv_type = view.findViewById(R.id.rcv_type);
        rcv_food = view.findViewById(R.id.rcv_food);

    }

    private void setOnClickItem() {
        iv_add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open new Fragment add food
                dialog = new Dialog(getActivity());
                dialog.getWindow().getAttributes().windowAnimations = R.style.up_down;
                dialog.setContentView(R.layout.add_food_fragment);
                dialog.setCancelable(true);
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                if (dialog != null && dialog.getWindow() != null) {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                initDialog();


                //Spinner to show list add Food Ways
                spinner();

                dialog.show();
            }

            private void initDialog() {
                spWays = dialog.findViewById(R.id.spWays);
                ln1 = dialog.findViewById(R.id.ln_food_ways_1);
                ln2 = dialog.findViewById(R.id.ln_food_ways_2);
                ln3 = dialog.findViewById(R.id.ln_food_ways_3);
                ln4 = dialog.findViewById(R.id.ln_food_ways_4);
                ln5 = dialog.findViewById(R.id.ln_food_ways_5);
                ivWay1 = dialog.findViewById(R.id.ivWay1);
                ivWay2 = dialog.findViewById(R.id.ivWay2);
                ivWay3 = dialog.findViewById(R.id.ivWay3);
                ivWay4 = dialog.findViewById(R.id.ivWay4);
                ivWay5 = dialog.findViewById(R.id.ivWay5);
                tvWay1 = dialog.findViewById(R.id.tvWay1);
                tvWay2 = dialog.findViewById(R.id.tvWay2);
                tvWay3 = dialog.findViewById(R.id.tvWay3);
                tvWay4 = dialog.findViewById(R.id.tvWay4);
                tvWay5 = dialog.findViewById(R.id.tvWay5);
            }
        });
    }

    private void spinner() {
        String listSpinner[] = {"1 bước", "2 bước", "3 bước", "4 bước", "5 bước"};
        ArrayAdapter<String> spinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listSpinner);
        //Set drop down item
        spinner.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spWays.setAdapter(spinner);
        //Set event
        spWays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                switch (i+1) {
                    case 1:
                        ln1.setVisibility(View.VISIBLE);
                        ln2.setVisibility(View.GONE);
                        ln3.setVisibility(View.GONE);
                        ln4.setVisibility(View.GONE);
                        ln5.setVisibility(View.GONE);
                        break;
                    case 2:
                        ln1.setVisibility(View.VISIBLE);
                        ln2.setVisibility(View.VISIBLE);
                        ln3.setVisibility(View.GONE);
                        ln4.setVisibility(View.GONE);
                        ln5.setVisibility(View.GONE);
                        break;
                    case 3:
                        ln1.setVisibility(View.VISIBLE);
                        ln2.setVisibility(View.VISIBLE);
                        ln3.setVisibility(View.VISIBLE);
                        ln4.setVisibility(View.GONE);
                        ln5.setVisibility(View.GONE);
                        break;
                    case 4:
                        ln1.setVisibility(View.VISIBLE);
                        ln2.setVisibility(View.VISIBLE);
                        ln3.setVisibility(View.VISIBLE);
                        ln4.setVisibility(View.VISIBLE);
                        ln5.setVisibility(View.GONE);
                        break;
                    case 5:
                        ln1.setVisibility(View.VISIBLE);
                        ln2.setVisibility(View.VISIBLE);
                        ln3.setVisibility(View.VISIBLE);
                        ln4.setVisibility(View.VISIBLE);
                        ln5.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}