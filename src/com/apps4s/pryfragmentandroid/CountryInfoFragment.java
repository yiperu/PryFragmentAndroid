package com.apps4s.pryfragmentandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CountryInfoFragment extends Fragment {

	private WebView webview;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Activity actividad = getActivity();
		
		
		if (actividad instanceof CountryDetailActivity ) {
			String country = ((CountryDetailActivity)getActivity()).getCountry();
			loadWebViewContent(country);
		}
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_country_info, container, false);
		webview = (WebView)view.findViewById(R.id.webView);
		
		//return super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}

	public void loadWebViewContent(String country) {
		webview.loadUrl("http://es.m.wikipedia.org/wiki/"+country);
		webview.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
			
		});
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
