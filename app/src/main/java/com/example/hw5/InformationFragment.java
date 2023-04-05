package com.example.hw5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;


public class InformationFragment extends Fragment {
    public InformationFragment(){
        super(R.layout.fragment_information);
    }

    @Nullable


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.getView();

        Bundle bundle = getArguments();
        TextView name = view2.findViewById(R.id.first_name);
        TextView secondName = view2.findViewById(R.id.second_name);
        TextView phone = view2.findViewById(R.id.phone_number);

        name.setText(bundle.getString(CONST_FIRST_NAME));
        secondName.setText(bundle.getString(CONST_SECOND_NAME));
        phone.setText(bundle.getString(CONST_PHONE));



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment contactsFragment = new ContactsFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                ft.replace(R.id.container, contactsFragment);
                ft.commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);


    }

    public static final String CONST_FIRST_NAME = "FIRSTNAME";
    public static final String CONST_SECOND_NAME = "SECONDNAME";
    public static final String CONST_PHONE = "PHONE";
    public static final String CONST_ID = "ID";


}


