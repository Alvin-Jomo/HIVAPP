package com.example.hivapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registeActivity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm, edPhoneNumber;
    Button btn;
    TextView tv;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);

        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextConfirmPassword);
        edPhoneNumber = findViewById(R.id.editTextPhonenumber);
        edEmail = findViewById(R.id.editTextRegEmail);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.editTextviewExistingUser);

        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String confirm = edConfirm.getText().toString().trim();
                String email = edEmail.getText().toString().trim();
                String number = edPhoneNumber.getText().toString().trim();


                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (username.matches("[0-9]+")) {
                    Toast.makeText(getApplicationContext(), "Name cannot be only numbers.", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    for (int i = 0; i < username.length() - 2; i++) {
                        if (username.charAt(i) == username.charAt(i + 1) && username.charAt(i) == username.charAt(i + 2)) {
                            Toast.makeText(getApplicationContext(), "Name cannot contain the same 3 consecutive letters.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }

                // Validate email
                if (!isValidEmail(email)) {
                    Toast.makeText(getApplicationContext(), "Invalid email format.", Toast.LENGTH_SHORT).show();
                    return;
                }


                // Validate phone number
                if (!isValidPhoneNumber(number)) {
                    Toast.makeText(getApplicationContext(), "Invalid phone number format. Must be 10 digits without decimals.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Validate password
                if (!isValidPassword(password)) {
                    Toast.makeText(getApplicationContext(),
                            "Password must be at least 6 characters long, contain an uppercase letter, a lowercase letter, and a special character.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate password confirmation
                if (!password.equals(confirm)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_SHORT).show();
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(registeActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        } else {
                            Toast.makeText(registeActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });


                // db.register(username, email, password, number);
                displayToast("Registration successful!");
                Intent intent = new Intent(registeActivity.this, LoginActivity.class);
                startActivity(intent);





            }

            private boolean isValidEmail(String email) {
                String regex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }

            private boolean isValidPhoneNumber(String phone) {
                String regex = "^\\d{10}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(phone);
                return matcher.matches();
            }

            private boolean isValidPassword(String password) {
                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(password);
                return matcher.matches();
            }
            private void displayToast(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we require an intend for user define activity
                Intent intent = new Intent(registeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}