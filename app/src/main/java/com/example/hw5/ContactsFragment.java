package com.example.hw5;

import static com.example.hw5.InformationFragment.CONST_FIRST_NAME;
import static com.example.hw5.InformationFragment.CONST_ID;
import static com.example.hw5.InformationFragment.CONST_PHONE;
import static com.example.hw5.InformationFragment.CONST_SECOND_NAME;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import kotlin.jvm.JvmField;


public class ContactsFragment extends Fragment {
    public ContactsFragment() {
        super(R.layout.fragment_contacts);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Contact firstContact = new Contact("Mike", "Smith", "2020327");
        Contact secondContact = new Contact("Bob", "Bale", "33333333");
        Contact thirdContact = new Contact("Robin", "Musk", "44444447");
        Contact fourthContact = new Contact("Jul", "Fisher", "523542357");
        List<Contact> contactList = Arrays.asList(firstContact, secondContact, thirdContact, fourthContact);
        View view1 = this.getView();

        TextView firstTextView = view1.findViewById(R.id.first_contact);
        TextView secondTextView = view1.findViewById(R.id.second_contact);
        TextView thirdTextView = view1.findViewById(R.id.third_contact);
        TextView fourthTextView = view1.findViewById(R.id.fourth_contact);


        Contact firstC = contactList.get(0);
        Contact secondC = contactList.get(1);
        Contact thirdC = contactList.get(2);
        Contact fourthC = contactList.get(3);

        firstTextView.setText(firstC.firstName + " " + firstC.secondName + " " + firstC.phoneHumber);
        secondTextView.setText(secondC.firstName + " " + secondC.secondName + " " + secondC.phoneHumber);
        thirdTextView.setText(thirdC.firstName + " " + thirdC.secondName + " " + thirdC.phoneHumber);
        fourthTextView.setText(fourthC.firstName + " " + fourthC.secondName + " " + fourthC.phoneHumber);

        Bundle bundle = new Bundle();
        Fragment informationFragment = new InformationFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();


        View.OnClickListener fistOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(CONST_FIRST_NAME, firstContact.firstName);
                bundle.putString(CONST_SECOND_NAME, firstContact.secondName);
                bundle.putString(CONST_PHONE, firstContact.phoneHumber);
                bundle.putInt(CONST_ID, 0);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };
        View.OnClickListener secondOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(CONST_FIRST_NAME, secondContact.firstName);
                bundle.putString(CONST_SECOND_NAME, secondContact.secondName);
                bundle.putString(CONST_PHONE, secondContact.phoneHumber);
                bundle.putInt(CONST_ID, 0);
                informationFragment.setArguments(bundle);
                ft.replace(R.id.container, informationFragment);
                ft.commit();

            }
        };
        View.OnClickListener thirdOnClick = new View.OnClickListener() {
            @Override
        public void onClick (View v){
            bundle.putString(CONST_FIRST_NAME, thirdContact.firstName);
            bundle.putString(CONST_SECOND_NAME, thirdContact.secondName);
            bundle.putString(CONST_PHONE, thirdContact.phoneHumber);
            bundle.putInt(CONST_ID, 0);
            informationFragment.setArguments(bundle);
            ft.replace(R.id.container, informationFragment);
            ft.commit();

        }
    };

    View.OnClickListener  fourthOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bundle.putString(CONST_FIRST_NAME, fourthContact.firstName);
            bundle.putString(CONST_SECOND_NAME, fourthContact.secondName);
            bundle.putString(CONST_PHONE, fourthContact.phoneHumber);
            bundle.putInt(CONST_ID, 0);
            informationFragment.setArguments(bundle);
            ft.replace(R.id.container, informationFragment);
            ft.commit();

        }
    };
        firstTextView.setOnClickListener(fistOnClick);
        secondTextView.setOnClickListener(secondOnClick);
        thirdTextView.setOnClickListener(thirdOnClick);
        fourthTextView.setOnClickListener(fourthOnClick);



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

    public static final String CONST_FIRST_NAME = "FIRSTNAME";
    public static final String CONST_SECOND_NAME = "SECONDNAME";
    public static final String CONST_PHONE = "PHONE";
    public static final String CONST_ID = "ID";
}
