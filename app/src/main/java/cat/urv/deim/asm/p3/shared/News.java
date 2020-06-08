package cat.urv.deim.asm.p3.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cat.urv.deim.asm.p2.common.R;
import cat.urv.deim.asm.p3.shared.NewsFragment;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsFragment.newInstance())
                    .commitNow();
        }
    }
}