package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cat.urv.deim.asm.p2.common.ui.login.LoginActivity;

public class ErrorLogin extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_login);

        this.getSupportActionBar().hide();

        button = (Button) findViewById(R.id.buttonTryAgain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
            public void openLogin(){
                Intent intent = new Intent(ErrorLogin.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
