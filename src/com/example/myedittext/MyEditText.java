package com.example.myedittext;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/** 
 * @author  张玉水 
 * @date  2016-5-24  11:24:07 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class MyEditText extends RelativeLayout {

	private EditText et;
	private TextView tv;
	
	
	private String NAMESPACE="http://schemas.android.com/apk/res/com.example.myedittext";
	private int maxLength;
	
	public MyEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (attrs!=null) {
			maxLength = attrs.getAttributeIntValue(NAMESPACE, "maxlength", 200);
		}
			
		
		init(context);
	}

	public MyEditText(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		
	}

	public MyEditText(Context context,int maxlenth) {
		super(context);
		maxLength=maxlenth;	
		init(context);
		
	}
	//初始化
	private void init(Context context) {
	    View view = View.inflate(context, R.layout.myedittext, null);
	    et = (EditText) view.findViewById(R.id.et);
	    
	   // et.setInputType(InputType.TYPE_CLASS_TEXT); //
	    et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)}); //设置输入长度
	    tv = (TextView) view.findViewById(R.id.tv);
	    int length = et.getText().toString().length();
		tv.setText(length+"/"+maxLength);
	    et.addTextChangedListener(new TextWatcher() {
			

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				int length = et.getText().toString().length();
				tv.setText(length+"/"+maxLength);
			}
		});
	    
	    addView(view);
		
	}
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	//瀹炵幇绫讳技浜嶦dittext鐨勬柟娉�
	public void setText(String s){
		et.setText(s);
	}
	public Editable getText(){
		return et.getText();
	}
	
	
}
