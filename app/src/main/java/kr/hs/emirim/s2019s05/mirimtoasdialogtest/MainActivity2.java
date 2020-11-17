package kr.hs.emirim.s2019s05.mirimtoasdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,email,editName,editEmail;
    TextView textToast;
    Button btn_click;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(btn_click_listener);
    }
    View.OnClickListener btn_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity2.this, R.layout.toast_dialog,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity2.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.ic_launcher_foreground);
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인",positiveButtonListener);
            dlg.setNegativeButton("취소",negativeButtonListener);
            dlg.show();
        }
    };

    DialogInterface.OnClickListener positiveButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            editName = dialogView.findViewById(R.id.edit_name);
            editEmail = dialogView.findViewById(R.id.edit_email);

            name.setText(editName.getText().toString());
            email.setText(editEmail.getText().toString());
        }
    };

    DialogInterface.OnClickListener negativeButtonListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast toast = new Toast(MainActivity2.this);
            toastView = View.inflate(MainActivity2.this, R.layout.dialog,null);
            textToast = toastView.findViewById(R.id.text_toast);
            textToast.setText("취소버튼을 누르셨네요.");
            toast.setView(toastView);
            Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            int xOffest = (int)(Math.random()*display.getWidth());
            int yOffest = (int)(Math.random()*display.getHeight());
            toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffest, yOffest);
            toast.show();

        }
    };
}