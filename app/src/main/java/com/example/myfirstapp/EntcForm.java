package com.example.myfirstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EntcForm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EntcForm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EntcForm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EntcForm.
     */
    // TODO: Rename and change types and number of parameters
    public static EntcForm newInstance(String param1, String param2) {
        EntcForm fragment = new EntcForm();
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
        View parentholder=inflater.inflate(R.layout.fragment_entc_form,container,false);
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getContext());


        // Inflate the layout for this fragment
        Button btn=(Button)parentholder.findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView name=(TextView)parentholder.findViewById(R.id.name);
                TextView email=(TextView)parentholder.findViewById(R.id.email);
                TextView prn=(TextView)parentholder.findViewById(R.id.prn);
                TextView additional=(TextView)parentholder.findViewById(R.id.multiAutoCompleteTextView);


                boolean status=dataBaseHelper.insert_values_entc(name.getText().toString(),email.getText().toString(),Integer.parseInt(prn.getText().toString()),additional.getText().toString());
                String s=(status)?("Successful"):("Failed");
                Toast.makeText(getContext(),"Submission "+s+" for ENTC Form",Toast.LENGTH_SHORT).show();
            }
        });

        return parentholder;

    }
}