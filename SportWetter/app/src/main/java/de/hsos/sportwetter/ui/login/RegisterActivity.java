package de.hsos.sportwetter.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import de.hsos.sportwetter.AppDatabase;
import de.hsos.sportwetter.MainActivity;
import de.hsos.sportwetter.R;
import de.hsos.sportwetter.classes.Preferences;
import de.hsos.sportwetter.classes.activity.Activity;
import de.hsos.sportwetter.classes.activity.ActivityDao;
import de.hsos.sportwetter.classes.user.User;
import de.hsos.sportwetter.classes.user.UserDao;
import de.hsos.sportwetter.databinding.ActivityRegisterBinding;
/**
 * @author Paul Dieterich
 * */
public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        EditText email = findViewById(R.id.email);
        Button registerbtn = findViewById(R.id.registerbtn);
        /**
         * registerBtn OnClick
         *
         * get Userinput from textviews
         * Geht die Userdao durch und schaut, ob der Username in der userDB existiert.
         * Falls nicht, wird der User erstellt.
         * */
        registerbtn.setOnClickListener(v -> {
            String userName = username.getText().toString();
            String passwd = password.getText().toString();
            String eMail = email.getText().toString();
            UserDao dao = AppDatabase.getDatabase(this).userDao();
            User result = null;
            for (User user : dao.getAllUsers()) {
                if (username.equals(user.getName())){
                    result = user;
                }
            }
            if (result == null) {
                User u = new User(userName, eMail, passwd);
                u.setUserID(dao.insertUser(u));
                Preferences.getInstance(this).setUser(u);
                Toast.makeText(RegisterActivity.this, "Create new User", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}