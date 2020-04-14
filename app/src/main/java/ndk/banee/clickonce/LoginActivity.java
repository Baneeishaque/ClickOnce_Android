package ndk.banee.clickonce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.javatuples.Triplet;

import java.util.Objects;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android14.ContextActivity;
import ndk.utils_android16.ValidationUtils;

public class LoginActivity extends ContextActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        Button buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Pair<Boolean, EditText> validationResult = ValidationUtils.nonEmptyCheckEditTextPairs(new Pair[]{new Pair<>(editTextMobileNumber, "Please Enter Your Mobile Number...")});

                if (Objects.requireNonNull(validationResult.first)) {

                    Pair<Integer, EditText> secondValidationResult = ValidationUtils.indianMobileNumberCheckEditTextPairs(new Triplet[]{new Triplet<>(editTextMobileNumber, "Please Correct Your Mobile Number...", "Sorry, Currently Service is Not Available for Outside India...")}, activityContext);

                    if (Objects.requireNonNull(secondValidationResult.first) == 1) {

                        ActivityUtils.startActivity(activityContext, DashboardActivity.class);

                    } else {

                        Objects.requireNonNull(secondValidationResult.second).requestFocus();
                    }

                } else {

                    Objects.requireNonNull(validationResult.second).requestFocus();
                }
            }
        });
    }
}
