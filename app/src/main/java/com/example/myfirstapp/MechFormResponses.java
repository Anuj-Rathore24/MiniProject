package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MechFormResponses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MechFormResponses extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MechFormResponses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MechFormResponses.
     */
    // TODO: Rename and change types and number of parameters
    public static MechFormResponses newInstance(String param1, String param2) {
        MechFormResponses fragment = new MechFormResponses();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentholder=inflater.inflate(R.layout.fragment_mech_form_responses,container,false);
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getContext());




        LinearLayout linearLayout =  (LinearLayout)parentholder.findViewById(R.id.Parent);
        Context context=getContext();
        TextView heading=new TextView(context);



        try {


            //list for storing class objects
            List<selectData> ourList;
            ourList = dataBaseHelper.show_result("Mechanical");
            Iterator<selectData> it = ourList.iterator();
            while (it.hasNext()) {
                //for every object in our list row is assigned there values
                selectData row;
                row = it.next();

                //creating new layout for every object as CONTAINER
                ConstraintLayout MainContainer = new ConstraintLayout(context);
                MainContainer.setId(View.generateViewId());

                linearLayout.addView(MainContainer);

                //Adding 2 TextView's one for label and another for name
                //label

                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(MainContainer);


                //Setting up Label For Name
                TextView NameLabel = new TextView(context);
                NameLabel.setId(View.generateViewId());
                NameLabel.setText("Name :");
                NameLabel.setTextSize(20);
                MainContainer.addView(NameLabel);

                //Adding Contraints
                constraintSet.constrainWidth(NameLabel.getId(), ConstraintSet.WRAP_CONTENT);
                constraintSet.constrainHeight(NameLabel.getId(), ConstraintSet.WRAP_CONTENT);
                constraintSet.connect(NameLabel.getId(), ConstraintSet.START, MainContainer.getId(), ConstraintSet.START);
                constraintSet.connect(NameLabel.getId(), ConstraintSet.TOP, MainContainer.getId(), ConstraintSet.TOP);


                //setting Name TextName
                TextView Name = new TextView(context);
                Name.setId(View.generateViewId());
                Name.setText(row.Name);
                Name.setTextSize(20);
                MainContainer.addView(Name);

                //   Initializing Button
                Button btn = new Button(context);
                btn.setId(View.generateViewId());
                btn.setText("Show Details");
                MainContainer.addView(btn);

                //adding constraint to Name TextView
                constraintSet.constrainWidth(Name.getId(), ConstraintSet.WRAP_CONTENT);
                constraintSet.constrainHeight(Name.getId(), ConstraintSet.WRAP_CONTENT);


                constraintSet.connect(Name.getId(), ConstraintSet.START, NameLabel.getId(), ConstraintSet.END);
                constraintSet.connect(Name.getId(), ConstraintSet.TOP, MainContainer.getId(), ConstraintSet.TOP);
                constraintSet.connect(Name.getId(), ConstraintSet.END, btn.getId(), ConstraintSet.START);


                //Adding Constraints to Btn
                constraintSet.constrainWidth(btn.getId(), ConstraintSet.WRAP_CONTENT);
                constraintSet.constrainHeight(btn.getId(), ConstraintSet.WRAP_CONTENT);


                constraintSet.connect(btn.getId(), ConstraintSet.START, Name.getId(), ConstraintSet.END);
                constraintSet.connect(btn.getId(), ConstraintSet.TOP, MainContainer.getId(), ConstraintSet.TOP);
                constraintSet.connect(btn.getId(), ConstraintSet.END, MainContainer.getId(), ConstraintSet.END);


                //function of Button
                btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(v.getContext(), DIsplayData.class);
                        intent.putExtra("OurObject", row);


                        startActivity(intent);


                    }

                });

                //Applying all Constraint Layout to out Main Container
                constraintSet.applyTo(MainContainer);

//

            }
        }catch(Exception e){
            Log.e("The Error is ->",e.toString());
        }
        return parentholder;
    }
}