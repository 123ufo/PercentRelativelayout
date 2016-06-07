# PercentRelativelayout

一个能以百分比来定义子控件大小的ViewGroup.该控件继承Relativelayout.所以有Relativelayout的所有属性

		<?xml version="1.0" encoding="utf-8"?>
	<com.example.customviewgroup2.view.PercentRelativeLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    tools:context="com.example.customviewgroup2.MainActivity">
	
	    <TextView
	        android:layout_width="wrap_content"
	        android:background="@android:color/darker_gray"
	        android:layout_height="wrap_content"
	        app:percentWidth="0.7"
	        app:percentHeight="0.5"
	        android:text="Hello World!"/>
	</com.example.customviewgroup2.view.PercentRelativeLayout>


![](http://i.imgur.com/otYSlNp.jpg)