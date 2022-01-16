package com.example.belove.ui.App.TotemView.TotemDataUpload;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

import androidx.lifecycle.ViewModel;

public class TotemDataUploadViewModel extends ViewModel {


    public String getExtension(Uri uri, Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    
}