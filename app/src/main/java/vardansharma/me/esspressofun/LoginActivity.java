package vardansharma.me.esspressofun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

  @Bind(R.id.et_email) EditText etEmail;
  @Bind(R.id.et_password) EditText etPassword;
  @Bind(R.id.btn_login) Button btnLogin;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);

    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (!validateFields()) return;

        //authenticate user over the server
      }
    });
  }

  private boolean validateFields() {
    final String email = etEmail.getText().toString().trim();
    final String password = etPassword.getText().toString().trim();
    boolean areValid = false;
    if (email.isEmpty()) {
      etEmail.setError("please enter your email");
    } else if (!isValidEmail(email)) {
      etEmail.setError("please enter valid email");
    } else if (password.isEmpty()) {
      etPassword.setError("please enter password");
    } else if (password.length() < 5) {
      etPassword.setError("password should be ateast 6 characters long");
    } else {
      areValid = true;
    }
    return areValid;
  }

  public static boolean isValidEmail(CharSequence target) {
    return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
  }
}
