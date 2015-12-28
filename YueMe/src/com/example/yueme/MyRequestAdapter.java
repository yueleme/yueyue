package com.example.yueme;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyRequestAdapter extends BaseAdapter {
	
	private List<Request> requestList;
	
	private LayoutInflater inflate;
	
	private Context context;
	
	public MyRequestAdapter(Context context,List<Request> requestList){
		this.context = context;
		this.requestList = requestList;
		inflate = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return requestList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return requestList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();  
			convertView = inflate.inflate(R.layout.item_my_request, null);
			holder.tvUser = (TextView)convertView.findViewById(R.id.tv_user);
			holder.tvTheme = (TextView)convertView.findViewById(R.id.tv_theme);
			holder.tvAct = (TextView)convertView.findViewById(R.id.tv_activity);
			holder.tvTime = (TextView)convertView.findViewById(R.id.tv_time);
			holder.ivProtrait = (ImageView)convertView.findViewById(R.id.iv_protrait);
			holder.ivPost = (ImageView)convertView.findViewById(R.id.iv_post);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.tvUser.setText(requestList.get(position).getUserName());
		holder.tvTheme.setText(requestList.get(position).getTheme());
		holder.tvAct.setText(requestList.get(position).getActivity());
		holder.tvTime.setText(requestList.get(position).getTime());
		return convertView;
	}
	
	
	class ViewHolder{
		TextView tvUser,tvTheme,tvAct,tvTime;
		ImageView ivProtrait,ivPost;
	}
	

}
