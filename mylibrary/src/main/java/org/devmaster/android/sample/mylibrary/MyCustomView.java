package org.devmaster.android.sample.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MyCustomView extends FrameLayout {

    private String mMyPrivateID;

    private TextView mText1;
    private TextView mText2;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_custom_view, this, false);
        addView(view);

        mText1 = (TextView) view.findViewById(R.id.text1);
        mText2 = (TextView) view.findViewById(R.id.text2);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        try {
            mMyPrivateID = a.getString(R.styleable.MyCustomView_MyPrivateID);
            if (!TextUtils.isEmpty(mMyPrivateID)) {
                mText2.setText(mMyPrivateID);
            } else {
                mText2.setText("No private ID");
            }
        } finally {
            a.recycle();
        }
    }
}
