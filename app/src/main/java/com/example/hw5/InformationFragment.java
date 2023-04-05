package com.example.hw5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Objects;


public class InformationFragment extends Fragment {
    public InformationFragment() {
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

        Fragment contactsFragment = new ContactsFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        Bundle bundle = getArguments();

        TextView name = view2.findViewById(R.id.first_name);
        TextView secondName = view2.findViewById(R.id.second_name);
        TextView phone = view2.findViewById(R.id.phone_number);

        EditText editFirstName = view2.findViewById(R.id.edit_first_name);
        EditText editSecondName = view2.findViewById(R.id.edit_second_name);
        EditText editPhoneNumber = view2.findViewById(R.id.edit_phone_number);
        Button saveChangesButton = view2.findViewById(R.id.save_changes_button);


        ArrayList<Contact> list = (ArrayList<Contact>) getArguments().getSerializable(CONST_INTENT_KEY);
        name.setText(list.get(bundle.getInt(CONST_ID)).firstName);
        secondName.setText(list.get(bundle.getInt(CONST_ID)).secondName);
        phone.setText(list.get(bundle.getInt(CONST_ID)).phoneHumber);


        Contact newContact = new Contact();
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editFirstName.getText().toString().isEmpty()) {
                    newContact.firstName = name.getText().toString();
                } else newContact.firstName = editFirstName.getText().toString();

                if (editSecondName.getText().toString().isEmpty()) {
                    newContact.secondName = secondName.getText().toString();
                } else newContact.secondName = editSecondName.getText().toString();

                if (editPhoneNumber.getText().toString().isEmpty()) {
                    newContact.phoneHumber = phone.getText().toString();
                } else newContact.phoneHumber = editPhoneNumber.getText().toString();


                Bundle bundle1 = new Bundle();
                list.set(bundle.getInt(CONST_ID), newContact);
                bundle1.putSerializable(CONST_INTENT_KEY, list);


                bundle1.putInt(CONST_ID, bundle.getInt(CONST_ID));
                contactsFragment.setArguments(bundle1);
                ft.replace(R.id.container, contactsFragment);
                ft.commit();
            }
        });


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                ft.replace(R.id.container, contactsFragment);
                ft.commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public static final String CONST_ID = "ID";
    public static final String CONST_INTENT_KEY = "key";


}


