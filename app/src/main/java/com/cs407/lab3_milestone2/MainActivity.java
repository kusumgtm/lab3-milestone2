package com.cs407.lab3_milestone2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Button firstFragmentButton = findViewById(R.id.firstFragmentButton);
        firstFragmentButton.setOnClickListener(new FirstFragmentButtonClickListener(fragmentManager));

        Button secondFragmentButton = findViewById(R.id.secondFragmentButton);
        secondFragmentButton.setOnClickListener(new SecondFragmentButtonClickListener(fragmentManager));
    }

    private static class FirstFragmentButtonClickListener implements View.OnClickListener {
        private final FragmentManager fragmentManager;

        public FirstFragmentButtonClickListener(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @Override
        public void onClick(View v) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, new FirstFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack("showing First")
                    .commit();
        }
    }

    private static class SecondFragmentButtonClickListener implements View.OnClickListener {
        private final FragmentManager fragmentManager;

        public SecondFragmentButtonClickListener(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @Override
        public void onClick(View v) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, new SecondFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack("showing Second")
                    .commit();
        }
    }
}
