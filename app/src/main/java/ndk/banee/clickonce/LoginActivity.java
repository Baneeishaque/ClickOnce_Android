package ndk.banee.clickonce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android14.ContextActivity;

public class LoginActivity extends ContextActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ActivityUtils.startActivity(activityContext, DashboardActivity.class);
            }
        });
    }
}
