package com.example.hw5;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment {

    public static ContactsFragment newInstance(List<Contact> contacts) {
        Bundle args = new Bundle();
        args.putSerializable(CONST_INTENT_KEY, (Serializable) contacts);
        ContactsFragment fragment = new ContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ContactsFragment() {
        super(R.layout.fragment_contacts);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Contact> data;
        Contact firstContact = new Contact("Mike", "Smith", "2020327");
        Contact secondContact = new Contact("Bob", "Bale", "33333333");
        Contact thirdContact = new Contact("Robin", "Musk", "44444447");
        Contact fourthContact = new Contact("Jul", "Fisher", "523542357");

        ArrayList<Contact> contactList = new ArrayList<Contact>();
        contactList.add(firstContact);
        contactList.add(secondContact);
        contactList.add(thirdContact);
        contactList.add(fourthContact);


        View view1 = this.getView();

        TextView firstTextView = view1.findViewById(R.id.first_contact);
        TextView secondTextView = view1.findViewById(R.id.second_contact);
        TextView thirdTextView = view1.findViewById(R.id.third_contact);
        TextView fourthTextView = view1.findViewById(R.id.fourth_contact);


        Bundle bundle = new Bundle();
        Fragment informationFragment = new InformationFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        if (getArguments() != null) {

            ArrayList<Contact> list = (ArrayList<Contact>) getArguments().getSerializable(CONST_INTENT_KEY);
            contactList = list;
        }
        ArrayList<Contact> finalContactList = contactList;
        View.OnClickListener fistOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable(CONST_INTENT_KEY, finalContactList);

                bundle.putInt(CONST_ID, 0);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };
        ArrayList<Contact> finalContactList1 = contactList;
        View.OnClickListener secondOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable(CONST_INTENT_KEY, finalContactList1);
                bundle.putInt(CONST_ID, 1);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };
        ArrayList<Contact> finalContactList2 = contactList;
        View.OnClickListener thirdOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable(CONST_INTENT_KEY, finalContactList2);
                bundle.putInt(CONST_ID, 2);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };

        ArrayList<Contact> finalContactList3 = contactList;
        View.OnClickListener fourthOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putSerializable(CONST_INTENT_KEY, finalContactList3);

                bundle.putInt(CONST_ID, 3);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };
        firstTextView.setOnClickListener(fistOnClick);
        secondTextView.setOnClickListener(secondOnClick);
        thirdTextView.setOnClickListener(thirdOnClick);
        fourthTextView.setOnClickListener(fourthOnClick);



        firstTextView.setText(contactList.get(0).firstName
                + " " + contactList.get(0).secondName + " " + contactList.get(0).phoneHumber);
        secondTextView.setText(contactList.get(1).firstName
                + " " + contactList.get(1).secondName + " " + contactList.get(1).phoneHumber);
        thirdTextView.setText(contactList.get(2).firstName
                + " " + contactList.get(2).secondName + " " + contactList.get(2).phoneHumber);
        fourthTextView.setText(contactList.get(3).firstName
                + " " + contactList.get(3).secondName + " " + contactList.get(3).phoneHumber);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);


    }


    public static final String CONST_INTENT_KEY = "key";

    public static final String CONST_ID = "ID";




}
