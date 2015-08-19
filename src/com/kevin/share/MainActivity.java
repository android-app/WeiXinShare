package com.kevin.share;

import java.io.File;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		File dir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		
		File file = new File(dir, "/logo.png");
		
		switch (item.getItemId()) {
		case R.id.action_share1:
			System.out.println(file.toURI());
			
			shareToFriend(file);
			return true;
		case R.id.action_share2:
			
			System.out.println(file.toURI());
			shareToTimeLine(file);
			
			return true;
		case R.id.action_share3:
			File video = new File(dir, "/test.mp4");
			shareToFriendVideo(video);
			
			return true;
		default:
			return super.onOptionsItemSelected(item);

		}
	}

	private void shareToFriend(File file) {
		
		Intent intent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm",
				"com.tencent.mm.ui.tools.ShareImgUI");
		intent.setComponent(comp);
		intent.setAction("android.intent.action.SEND");
		intent.setType("image/*");
		//intent.setFlags(0x3000001);
		intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
		startActivity(intent);
	}
	
	private void shareToFriendVideo(File file) {
		
		Intent intent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm",
				"com.tencent.mm.ui.tools.ShareImgUI");
		intent.setComponent(comp);
		intent.setAction("android.intent.action.SEND");
		intent.setType("video/*");
		//intent.setFlags(0x3000001);
		intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
		startActivity(intent);
	}
	
	private void shareToTimeLine(File file) {
		Intent intent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm",
				"com.tencent.mm.ui.tools.ShareToTimeLineUI");
		intent.setComponent(comp);
		intent.setAction("android.intent.action.SEND");
		intent.setType("image/*");
		//intent.setFlags(0x3000001);
		intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
		startActivity(intent);
	}
}
