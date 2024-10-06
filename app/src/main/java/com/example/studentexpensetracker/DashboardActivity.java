package com.example.studentexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    private ImageButton backButton, logOutButton, profileButton;
    private CardView expenseCard, khatabookCard, splitbillsCard, analyticsCard, helpCard, settingsCard;
    private TextView userName, institutionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Binding the views
        backButton = findViewById(R.id.backB);
        logOutButton = findViewById(R.id.logOutB);
        profileButton = findViewById(R.id.profileB);
        expenseCard = findViewById(R.id.expenseCard);
        khatabookCard = findViewById(R.id.khatabookCard);
        splitbillsCard = findViewById(R.id.splitbillsCard);
        analyticsCard = findViewById(R.id.analyticssCard);
        helpCard = findViewById(R.id.helpCard);
        settingsCard = findViewById(R.id.settingsCard);
        userName = findViewById(R.id.textView2);
        institutionName = findViewById(R.id.textView3);

        // Setting text (if required dynamically)
        userName.setText("Chetan Patil");
        institutionName.setText("PCCOER");

        // Setting click listeners
        backButton.setOnClickListener(v -> {
            // Action for back button (finish activity or navigation)
            finish();
        });

        logOutButton.setOnClickListener(v -> {
            // Action for logout (like navigating to login page or session management)
            Toast.makeText(DashboardActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
            // Add navigation logic here if necessary
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(intent);
        });

        profileButton.setOnClickListener(v -> {
            // Navigate to profile page or show a profile dialog
            Toast.makeText(DashboardActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        expenseCard.setOnClickListener(v -> {
            // Action for expense card click (navigate to expense page)
            Toast.makeText(DashboardActivity.this, "Expense clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, ExpenseActivity.class);
            startActivity(intent);
        });

        khatabookCard.setOnClickListener(v -> {
            // Action for khatabook card click
            Toast.makeText(DashboardActivity.this, "Khatabook clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, KhatabookActivity.class);
            startActivity(intent);
        });

        splitbillsCard.setOnClickListener(v -> {
            // Action for split bills card click
            Toast.makeText(DashboardActivity.this, "Split Bills clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, SplitBillsActivity.class);
            startActivity(intent);
        });

        analyticsCard.setOnClickListener(v -> {
            // Action for analytics card click
            Toast.makeText(DashboardActivity.this, "Analytics clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, AnalyticsActivity.class);
            startActivity(intent);
        });

        helpCard.setOnClickListener(v -> {
            // Action for help card click
            Toast.makeText(DashboardActivity.this, "Help clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, HelpActivity.class);
            startActivity(intent);
        });

        settingsCard.setOnClickListener(v -> {
            // Action for settings card click
            Toast.makeText(DashboardActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}
