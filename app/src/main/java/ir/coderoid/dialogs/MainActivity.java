package ir.coderoid.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button alert, dialog, customDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = (Button) findViewById(R.id.alert);
        dialog = (Button) findViewById(R.id.dialog);
        customDialog = (Button) findViewById(R.id.custom_dialog);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("متن نمایشی شما در دیالوگ");
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_Dialog();
            }
        });
        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_custom_dialog();
            }
        });
    }
    private void showAlertDialog(String str){
        final AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
        alert.setTitle("Title of your Dialog");
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setMessage(str);
        alert.setButton(Dialog.BUTTON_POSITIVE, "ادامه", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "شما روی دکمه ادامه کلیک کردید!", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setButton(Dialog.BUTTON_NEGATIVE, "لغو", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
                Toast.makeText(getBaseContext(), "دیالوگ لغو گردید!", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setButton(Dialog.BUTTON_NEUTRAL, "امتیاز", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.cancel();
                Toast.makeText(getBaseContext(), "به برنامه امتیاز دهید!", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }
    private void show_Dialog(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("عنوان دیالوگ");
        dialog.setContentView(R.layout.dialog_content);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getBaseContext(), "دیالوگ لغو گردید!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    private void show_custom_dialog(){
        FragmentManager fragmentManager = getFragmentManager();
        CustomDialog cd = new CustomDialog();
        cd.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.dial_sett_style);
        cd.show(fragmentManager, "show custom dialog!");
    }
}
