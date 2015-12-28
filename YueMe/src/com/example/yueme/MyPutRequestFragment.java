package com.example.yueme;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyPutRequestFragment extends Fragment{
	
	private ListView listview;
	
	private List<Request> requestList;
	
	private MyRequestAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_my_request, null);
		listview = (ListView)view.findViewById(R.id.listview_mine);
		initView();
		return view;
	}
	
	private void initView(){
		adapter = new MyRequestAdapter(getActivity().getApplicationContext(),initDate());
		listview.setAdapter(adapter);
	}

	private List<Request> initDate(){
		requestList = new ArrayList<Request>();
		for(int i = 0; i < 10; i++){
			Request request = new Request();
			request.setUserName("cc");
			request.setTheme("我要打篮球啊，谁陪我");
			request.setActivity("篮球类");
			request.setTime("明天9点");
			requestList.add(request);
		}
		return requestList;
	}
}
