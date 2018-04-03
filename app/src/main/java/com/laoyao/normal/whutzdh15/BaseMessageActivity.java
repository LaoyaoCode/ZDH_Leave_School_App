package com.laoyao.normal.whutzdh15;

import android.app.Dialog;
import android.provider.UserDictionary;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.laoyao.normal.whutzdh15.Tools.PopUpAdapter;
import com.laoyao.normal.whutzdh15.Tools.PopUpClickInterface;

import java.util.ArrayList;
import java.util.List;

public class BaseMessageActivity extends AppCompatActivity implements PopUpClickInterface
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_message) ;

        Button test = (Button)findViewById(R.id.test) ;
        final List<String> words = new ArrayList<String>();
        words.add("2014");
        words.add("2015");
        words.add("2016");
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(words);
            }
        });
    }

    private void setDialog(List<String> displayStrings)
    {
        final Dialog mSelectDialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pop_up_windows, null);

        RecyclerView rv = (RecyclerView)root.findViewById(R.id.items_display_rv) ;
        //添加分割线
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) ;
        rv.setLayoutManager(linearLayoutManager);
        PopUpAdapter adapter= new PopUpAdapter(displayStrings, this , this , mSelectDialog) ;
        rv.setAdapter(adapter);

        //设置离开按钮
        root.findViewById(R.id.pop_up_cancel_button).setClickable(true);
        root.findViewById(R.id.pop_up_cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectDialog.dismiss();
            }
        });

        mSelectDialog.setContentView(root);
        Window dialogWindow = mSelectDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.DialogAnimation); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);

        mSelectDialog.show();
    }

    @Override
    public void Click(String words)
    {
        Toast.makeText(BaseMessageActivity.this ,
                words , Toast.LENGTH_SHORT).show();
    }
}
