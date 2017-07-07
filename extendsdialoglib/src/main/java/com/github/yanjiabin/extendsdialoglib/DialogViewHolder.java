package com.github.yanjiabin.extendsdialoglib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogViewHolder {
	private final SparseArray<View> mViews;
	private View mDialogView;

	private DialogViewHolder(Context context, int layoutId) {
		this.mViews = new SparseArray<View>();
		mDialogView = View.inflate(context, layoutId, null);
	}

	public static DialogViewHolder get(Context context, int layoutId) {
		return new DialogViewHolder(context, layoutId);
	}

	public View getConvertView() {
		return mDialogView;

	}

	/**
	 * Set the string for TextView
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public DialogViewHolder setText(int viewId, CharSequence text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}


	/**
	 *  设置给本地的图片资源给imageview
	 * @param viewId
	 * @param imageRes
	 * @return
	 */
	public DialogViewHolder setImageRes(int viewId, int imageRes) {
		ImageView image = getView(viewId);
		image.setImageResource(imageRes);
		return this;
	}

	/**
	 *
	 * @param viewId  imageview 的id
	 * @param drawable  要给imageview设置的drawable
	 * @return
	 */
	public DialogViewHolder setImageDrawable(int viewId, Drawable drawable) {
		ImageView image = getView(viewId);
		image.setImageDrawable(drawable);
		return this;
	}

	/**
	 * set view visible
	 * 
	 * @param viewId
	 * @return  true 表示的是要显示控件  如果传入的是false的话就要隐藏
	 */
	public DialogViewHolder setViewViSibleOrNot(int viewId,boolean isShow) {
		TextView view = getView(viewId);
		view.setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
		return this;
	}

	/**
	 * set view INVISIBLE
	 * @param viewId
	 * @return
	 */
	public DialogViewHolder setViewInVisiable(int viewId) {
		TextView view = getView(viewId);
		view.setVisibility(View.INVISIBLE);
		return this;
	}

	/**
	 * 设置点击
	 */
	public DialogViewHolder setOnClick(int viewId, OnClickListener onClick) {
		View view = getView(viewId);
		view.setOnClickListener(onClick);
		return this;
	}

	/**
	 * Through control the Id of the access to control, if not join views
	 * 
	 * @param viewId
	 * @return
	 */

	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mDialogView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}
}
