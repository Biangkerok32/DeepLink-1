package com.appybuilder.sunny.DeepLink;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.annotations.androidmanifest.*;
import com.google.appinventor.components.annotations.UsesActivities;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;

@DesignerComponent(version = 1, description ="Adds deep link support<br> Developed by Sunny Gupta", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "https://res.cloudinary.com/andromedaviewflyvipul/image/upload/c_scale,h_20,w_20/v1571472765/ktvu4bapylsvnykoyhdm.png")
@UsesActivities(activities = {@ActivityElement(intentFilters = {@IntentFilterElement(actionElements = {@ActionElement(name = "android.intent.action.VIEW")}, categoryElements = {@CategoryElement(name = "android.intent.category.DEFAULT"), @CategoryElement(name = "android.intent.category.BROWSABLE")}, dataElements = {@DataElement(scheme = "deepLink",host="Screen1"), @DataElement(scheme = "https",host="community.kodular.io")})},name="com.appybuilder.sunny.DeepLink.DeepLink$DeepActivity")})
@SimpleObject(external=true)
public final class DeepLink extends AndroidNonvisibleComponent{
	public DeepLink(ComponentContainer container) {
    	  super(container.$form());
    }
  
    public static class DeepActivity extends Activity{
	@Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        if (getIntent() != null){
            Uri uri = getIntent().getData();
            if (uri != null){
				PackageManager packageManager = getPackageManager();
        		Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
				intent.putExtra("APP_INVENTOR_START",'"'+ uri.toString() +'"');
        		startActivity(intent);
				finish();
            }
        }
    }
}
}
