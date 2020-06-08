package cat.urv.deim.asm.p2.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import cat.urv.deim.asm.p2.common.ui.login.LoginActivity;

public class Help3 extends AppCompatActivity {

    private Button button;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help3);

        this.getSupportActionBar().hide();

       /* SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall", "" );

        if(FirstTime.equals("Yes")) {

            Intent intent = new Intent(Help3.this, LoginActivity.class);
            startActivity(intent);

        }
        else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTimeInstall", "Yes");
            editor.apply();
        }
*/


        button = (Button) findViewById(R.id.skipButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handler != null)
                    handler.removeCallbacksAndMessages(null);
                startLogin();
            }

        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, 2000);
    }

    public void startNextActivity(){
        Intent intent = new Intent(Help3.this, LoginActivity.class);
        startActivity(intent);
    }

    public void startLogin(){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        // clear handler on stop
        if (handler != null)
            handler.removeCallbacksAndMessages(null);
    }
}
