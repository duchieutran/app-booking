package com.example.appbooking.page.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.appbooking.R;
import com.example.appbooking.page.DashboardActivity;

public class BillHistory extends Fragment {
    Button a;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Gắn layout vào Fragment
        return inflater.inflate(R.layout.activity_payment, container, false);
    }




}
