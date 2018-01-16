package com.example.lenovo.pongmusicdemo.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.example.lenovo.pongmusicdemo.applaction.App;
import com.example.lenovo.pongmusicdemo.bean.Timebean;
import com.example.lenovo.pongmusicdemo.bean.Titlebean;
import com.example.lenovo.pongmusicdemo.fragment.CoverFragment;
import com.example.lenovo.pongmusicdemo.fragment.LrcFragment;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
	private static final String TAG = "MyService";
	int flag = 0;
	boolean islocal = false;
	private Timer timer;
	//创建中间人对象
	MyBinder binder = new MyBinder();
	int num = 0;
	int msize = 0;
	//全局的 在线音乐
	String showlink;
	public static MediaPlayer mediaPlayer;
	private TimerTask task;
	public static Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {

				//接收到PLayerActivity的seekbar传来的进度
				int progress = (int) msg.obj;
				int duration = mediaPlayer.getDuration();

				int a = progress * duration / 100;
				mediaPlayer.seekTo(a);//播放到相应位置

			} else if (msg.what == 2) {
				int time = (int) msg.obj;
				//Log.i("-----",time+"");
				mediaPlayer.seekTo(time);
			}
		}
	};

	//服务创建的时候
	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		super.onCreate();

		mediaPlayer = new MediaPlayer();
		timer = new Timer();

	}

	//绑定服务的时候
	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "onBind");
		// 返回binder对象
		return binder;
	}

	//解除绑定
	@Override
	public boolean onUnbind(Intent intent) {

		Log.i(TAG, "onUnbind");
		return super.onUnbind(intent);
	}

	//销毁的时候
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onDestroy");

		if (mediaPlayer != null) {//释放
			mediaPlayer.release();
			mediaPlayer = null;
		}

		super.onDestroy();
	}

	public void jieQian() {
		Log.i("---", "你数同意了,借你50块");
	}

	//服务中播放音乐的方法
	public void playMusic(final String show_link) {
		Log.i(TAG, "play");
		mediaPlayer.reset();

		try {

			mediaPlayer.setDataSource(this, Uri.parse(show_link));

			mediaPlayer.prepareAsync();
			mediaPlayer.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					Log.i(TAG, "ok");
					islocal = false;
					mediaPlayer.start();
					final int size = App.list_scan.size();
					msize = size;
					for (int i = 0; i < size; i++) {
						if (App.list_scan.get(i).getPath().equals(show_link)) {

							islocal = true;
							num = i;
						}
					}
					if (islocal == false) {
						showlink = show_link;
						num = -1;
					}
					Log.i("---播放器----", num + "");
					mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
						@Override
						public void onCompletion(MediaPlayer mp) {
							switch (App.xunhuan) {
								case 1:
									Log.i("--size---", size + "");
									if (num < size - 1) {
										num++;
										next();
									} else {
										num = 0;
										next();
									}
									Log.i("--播放---", num + "");

									break;

								case 2:
									mediaPlayer.start();
									break;
								case 3:
									Random random = new Random();
									num = random.nextInt(size);
									next();
									break;
							}
							if (num > 0) {
								EventBus.getDefault().postSticky(new Titlebean(App.list_scan.get(num).getText_song(), App.list_scan.get(num).getText_singer(), null));
							}
						}
					});
					flag = 0;
					task = new TimerTask() {
						@Override
						public void run() {
							int currentPosition = mediaPlayer.getCurrentPosition();
							int duration = mediaPlayer.getDuration();
							EventBus.getDefault().postSticky(new Timebean(currentPosition, duration));
							//	Log.i("------","走一次");
							//发送给歌词的fragment,把当前的时间
							Message message = new Message();
							long time = (long) currentPosition;
							message.obj = time;
							message.what = 0;
							LrcFragment.handler.sendMessage(message);

						}
					};

					timer.schedule(task, 0, 1000);
				}
			});

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void stopMusic() {
		if (mediaPlayer != null && flag == 0) {
			mediaPlayer.pause();
			CoverFragment.albumcover.pause();//暂停的动画
			task.cancel();
			flag = 1;
		} else {
			CoverFragment.albumcover.start();//继续的动画
			mediaPlayer.start();
			flag = 0;
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					int currentPosition = mediaPlayer.getCurrentPosition();
					int duration = mediaPlayer.getDuration();
					EventBus.getDefault().postSticky(new Timebean(currentPosition, duration));
					//Log.i("------","走一次");
					long time = (long) currentPosition;
					Message message = new Message();
					message.obj = time;
					message.what = 0;
					LrcFragment.handler.sendMessage(message);
				}
			};
			timer.schedule(task, 0, 1000);
		}
	}

	private void next() {

		try {
			mediaPlayer.reset();

			if (showlink != null && islocal == false) {
				mediaPlayer.setDataSource(this, Uri.parse(showlink));
			} else {
				mediaPlayer.setDataSource(this, Uri.parse(App.list_scan.get(num).getPath()));
			}
			mediaPlayer.prepareAsync();
			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mediaPlayer) {
					mediaPlayer.start();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//点击 上一首
	private void musicShang() {
		if (num > 0) {//如果不是第一首歌 就播放前一首歌
			num = num - 1;
		} else {
			num = 0;
			//Toast.makeText(this, "已经是第一首歌", Toast.LENGTH_SHORT).show();
		}
		Log.i("-----", num + "");
		try {

			mediaPlayer.reset();
			if (showlink != null && islocal == false) {
				mediaPlayer.setDataSource(this, Uri.parse(showlink));
			} else {
				mediaPlayer.setDataSource(this, Uri.parse(App.list_scan.get(num).getPath()));
			}

			mediaPlayer.prepareAsync();
			mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mp) {
					EventBus.getDefault().postSticky(new Titlebean(App.list_scan.get(num).getText_song(), App.list_scan.get(num).getText_singer(), null));
					mediaPlayer.start();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//点击 下一首
	private void musicXia() {
		if(num<msize-1){
			//不是最后一首,就一直加1
			num++;
		}else{
			num=0;
		}
		Log.i("-----",num+"");
		try {

			mediaPlayer.reset();
			if(showlink!=null){
				mediaPlayer.setDataSource(this, Uri.parse(showlink));
			}else {
				mediaPlayer.setDataSource(this, Uri.parse(App.list_scan.get(num).getPath()));
			}
			mediaPlayer.prepareAsync();
			mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mp) {
					EventBus.getDefault().postSticky(new Titlebean(App.list_scan.get(num).getText_song(),App.list_scan.get(num).getText_singer(),null));
					mediaPlayer.start();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	//中间人
	public class MyBinder extends Binder{

		public void jieQianBinder(){
			jieQian();
		}
		//中间人里面播放的方法
		public void playInBinder(String show_link) {

			playMusic(show_link);
		}
		public void stopInBinder() {

			stopMusic();
		}

		//上一首
		public void shang() {
			musicShang();
		}

		//下一首
		public void xia() {
			musicXia();
		}
	}
}
