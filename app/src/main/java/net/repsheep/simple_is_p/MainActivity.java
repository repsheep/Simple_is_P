package net.repsheep.simple_is_p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //判定される数字
    private int checkedNumber=57;

    //判定される数字の入力欄
    private EditText checkedNumberEditText;
    //判定の実行ボタン
    private Button checkNumberButton;
    //判定結果を表示するテキストビュー
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ビューの変数を初期化する
        checkedNumberEditText=findViewById(R.id.checked_number);
        checkNumberButton=findViewById(R.id.check_isP);
        resultTextView=findViewById(R.id.result);

        //判定される数字の初期値をEditTextにセットする
        checkedNumberEditText.setText(""+checkedNumber);

        //判定される数字を更新する
        checkNumberButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //入力値を文字列で取り出す
                String checkedNumberString=checkedNumberEditText.getText().toString();
                //int型に変換してから代入する
                checkedNumber=Integer.valueOf(checkedNumberString);

                if (checkedNumber<2) resultTextView.setText(""+checkedNumber+"は素数ではありません");
                else if (checkedNumber==2) resultTextView.setText(""+checkedNumber+"は素数です");
                else if(checkedNumber%2==0) resultTextView.setText(""+checkedNumber+"は素数ではありません");
                else{
                    int flag=1;
                    for(int i=3;i*i<=checkedNumber;i+=2){
                        if(checkedNumber%i==0) {
                            resultTextView.setText("" + checkedNumber + "は素数ではありません");
                            flag = 0;
                        }
                    }
                    if(flag==1) resultTextView.setText(""+checkedNumber+"は素数です");
                }
            }
        });
    }
}