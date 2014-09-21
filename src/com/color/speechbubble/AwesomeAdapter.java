package com.color.speechbubble;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * AwesomeAdapter is a Custom class to implement custom row in ListView
 * 
 * @author Adil Soomro
 * 
 */
@SuppressLint("NewApi")
public class AwesomeAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Message> mMessages;

	public AwesomeAdapter(Context context, ArrayList<Message> messages) {
		super();
		this.mContext = context;
		this.mMessages = messages;
	}

	@Override
	public int getCount() {
		return mMessages.size();
	}

	@Override
	public Object getItem(int position) {
		return mMessages.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Message message = (Message) this.getItem(position);

		ViewHolder holderleft;
		ViewHolder holderright;
		if (message.isMine()) {
			
				holderright = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.sms_row_right, parent, false);
				holderright.message = (TextView) convertView
						.findViewById(R.id.message_textright);
				holderright.imageP = (ImageView) convertView
						.findViewById(R.id.imageViewright);
				convertView.setTag(holderright);
			
				holderright = (ViewHolder) convertView.getTag();

			holderright.message.setText(message.getMessage());

			LayoutParams lp = (LayoutParams) holderright.message.getLayoutParams();
			LayoutParams lpR = (LayoutParams) holderright.imageP.getLayoutParams();
			
			holderright.message
				.setBackgroundResource(R.drawable.speech_bubble_green);
			holderright.message.setLayoutParams(lp);
			holderright.imageP.setLayoutParams(lpR);
			
		} else {
			Log.e("=", "You");

				holderleft = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.sms_row, parent, false);
				holderleft.message = (TextView) convertView
						.findViewById(R.id.message_text);
				holderleft.imageP = (ImageView) convertView
						.findViewById(R.id.imageView);
				convertView.setTag(holderleft);
		
				
				holderleft = (ViewHolder) convertView.getTag();
			holderleft.message.setText(message.getMessage());

			LayoutParams lp = (LayoutParams) holderleft.message.getLayoutParams();
			LayoutParams lpR = (LayoutParams) holderleft.imageP.getLayoutParams();

			holderleft.message
			.setBackgroundResource(R.drawable.speech_bubble_orange);
			holderleft.message.setLayoutParams(lp);
			holderleft.imageP.setLayoutParams(lpR);

			
		}
		return convertView;
	}

	private static class ViewHolder {
		TextView message;
		ImageView imageP;
	}


	@Override
	public long getItemId(int position) {
		// Unimplemented, because we aren't using Sqlite.
		return position;
	}

}
