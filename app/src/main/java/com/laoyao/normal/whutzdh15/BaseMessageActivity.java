package com.laoyao.normal.whutzdh15;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.provider.UserDictionary;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.laoyao.normal.whutzdh15.Tools.PopUpAdapter;
import com.laoyao.normal.whutzdh15.Tools.PopUpClickInterface;
import com.laoyao.normal.whutzdh15.Tools.StringDispose;

import java.util.ArrayList;
import java.util.List;

public class BaseMessageActivity extends AppCompatActivity implements PopUpClickInterface
{
    //年级总字符串
    private List<String> YearStrings = new ArrayList<String>() ;
    //选择的年级
    private String SelectYear = null ;
    //显示选择年级的text view
    private TextView DisplayYearTV = null ;

    //专业总字符串
    private List<String> ProfessionStrings = new ArrayList<String>() ;
    //选择的专业
    private String SelectProfession = null ;
    //显示的专业
    private TextView DisplayProfessionTV = null ;

    //班级总字符串
    private List<String> ClassStrings = new ArrayList<String>() ;
    //选择的班级
    private String SelectClass = null ;
    //显示的班级
    private TextView DisplayClassTV = null ;

    //住宿园区总字符串
    private List<String> LivePartStrings = new ArrayList<String>() ;
    //选择的住宿园区
    private String SelectLivePart = null ;
    //显示的住宿园区
    private TextView DisplayLivePartTV = null ;

    //是否在武汉库总字符串
    private List<String> IsInWuhanStrings = new ArrayList<String>() ;
    //选择的是否在武汉
    private String SelectIsInWuhan = null ;
    //显示的是否在武汉
    private TextView DisplayIsInWuhanTV = null ;

    private EditText StudentNumber = null ;
    private EditText MName = null ;
    private EditText LivePlace = null ;
    private EditText MPhone = null ;
    private EditText EName = null ;
    private EditText EPhone = null ;
    private EditText FName = null ;
    private EditText FPhone = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_message) ;

        //获取所有输入的信息
        StudentNumber = (EditText)findViewById(R.id.abm_study_number_et) ;
        MName = (EditText)findViewById(R.id.abm_name_et) ;
        LivePlace = (EditText)findViewById(R.id.abm_live_place_et) ;
        MPhone = (EditText)findViewById(R.id.abm_mphone_et) ;
        EName = (EditText)findViewById(R.id.abm_e_name_et) ;
        EPhone = (EditText)findViewById(R.id.abm_e_phone_et) ;
        FName = (EditText)findViewById(R.id.abm_family_name_et) ;
        FPhone = (EditText)findViewById(R.id.abm_family_phone_et) ;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }


        //初始化年级字符串
        YearStrings.add("2014");
        YearStrings.add("2015");
        YearStrings.add("2016");

        DisplayYearTV = (TextView)findViewById(R.id.abm_year_tv) ;
        //设置年级点击事件
        findViewById(R.id.abm_year_ll).setClickable(true);
        findViewById(R.id.abm_year_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(YearStrings) ;
            }
        });

        ProfessionStrings.add("自动化");
        ProfessionStrings.add("自动化ZY");
        ProfessionStrings.add("电气");
        ProfessionStrings.add("电气ZY");

        DisplayProfessionTV = (TextView)findViewById(R.id.abm_profession_tv) ;
        //设置专业点击时间
        findViewById(R.id.abm_profession_ll).setClickable(true);
        findViewById(R.id.abm_profession_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(ProfessionStrings) ;
            }
        });

        ClassStrings.add("自动化1501");
        ClassStrings.add("自动化1502");
        ClassStrings.add("自动化1503");
        ClassStrings.add("自动化1504");
        ClassStrings.add("自动化1505");
        ClassStrings.add("自动化ZY1501");
        ClassStrings.add("电气1501");
        ClassStrings.add("电气1502");
        ClassStrings.add("电气1503");
        ClassStrings.add("电气1504");
        ClassStrings.add("电气1505");
        ClassStrings.add("电气1506");
        ClassStrings.add("电气ZY1501");

        DisplayClassTV = (TextView)findViewById(R.id.abm_class_tv) ;
        //设置专业点击时间
        findViewById(R.id.abm_class_ll).setClickable(true);
        findViewById(R.id.abm_class_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(ClassStrings) ;
            }
        });

        //初始化年级字符串
        LivePartStrings.add("东院");
        LivePartStrings.add("西院");

        DisplayLivePartTV = (TextView)findViewById(R.id.abm_live_school_part_tv) ;
        //设置年级点击事件
        findViewById(R.id.abm_live_school_part_ll).setClickable(true);
        findViewById(R.id.abm_live_school_part_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(LivePartStrings) ;
            }
        });


        //初始化是否在武汉字符串
        IsInWuhanStrings.add("是");
        IsInWuhanStrings.add("否");

        DisplayIsInWuhanTV = (TextView)findViewById(R.id.abm_is_wuhan_tv) ;
        //设置年级点击事件
        findViewById(R.id.abm_is_wuhan__ll).setClickable(true);
        findViewById(R.id.abm_is_wuhan__ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDialog(IsInWuhanStrings) ;
            }
        });

        Button saveButton = (Button)findViewById(R.id.abm_save_button) ;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //检查如果数据符合要求则保存，并且转到下一个场景
                if(CheckDatasValid())
                {

                }
            }
        });
    }

    private void setDialog(List<String> displayStrings)
    {
        final Dialog mSelectDialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pop_up_windows, null);

        if(displayStrings.size() > 4)
        {
            root = (LinearLayout) LayoutInflater.from(this).inflate(
                    R.layout.pop_up_windows_more4, null);
        }

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
        if(YearStrings.contains(words))
        {
            DisplayYearTV.setText(words);
            SelectYear = words ;
        }

        if(ProfessionStrings.contains(words))
        {
            DisplayProfessionTV.setText(words);
            SelectProfession = words ;
        }

        if(ClassStrings.contains(words))
        {
            DisplayClassTV.setText(words);
            SelectClass = words ;
        }

        if(LivePartStrings.contains(words))
        {
            DisplayLivePartTV.setText(words);
            SelectLivePart = words ;
        }

        if(IsInWuhanStrings.contains(words))
        {
            DisplayIsInWuhanTV.setText(words);
            SelectIsInWuhan = words ;
        }
    }

    private boolean CheckDatasValid()
    {
        String sNumber = StudentNumber.getText().toString().trim();
        String mName = MName.getText().toString().trim();
        String livePlace = LivePlace.getText().toString().trim();
        String mPhone = MPhone.getText().toString().trim();
        String eName = EName.getText().toString().trim();
        String ePhone = EPhone.getText().toString().trim();
        String fName = FName.getText().toString().trim();
        String fPhone = FPhone.getText().toString().trim();


        //检查是否有数据没有填写
        if(SelectYear == null || SelectIsInWuhan == null || SelectLivePart == null ||
                SelectClass == null || SelectProfession == null || sNumber.isEmpty() ||
                mName.isEmpty() || livePlace.isEmpty() || mPhone.isEmpty() || eName.isEmpty() ||
                ePhone.isEmpty() || fName.isEmpty() || fPhone.isEmpty())
        {
            Toast.makeText(this , "数据填写不完整" , Toast.LENGTH_SHORT).show() ;
            return false ;
        }

        if(!StringDispose.IsTotalNumber(sNumber))
        {
            Toast.makeText(this , "学号格式错误" , Toast.LENGTH_SHORT).show() ;
            return false ;
        }

        if(!StringDispose.IsTotalNumber(mPhone) || !StringDispose.IsTotalNumber(ePhone)
                || !StringDispose.IsTotalNumber(fPhone))
        {
            Toast.makeText(this , "联系方式格式错误" , Toast.LENGTH_SHORT).show() ;
            return false ;
        }

        //保存所有数据到SharedPreferences中
        return true ;
    }


}
