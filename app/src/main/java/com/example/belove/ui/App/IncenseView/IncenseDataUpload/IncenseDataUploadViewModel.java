package com.example.belove.ui.App.IncenseView.IncenseDataUpload;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

import androidx.lifecycle.ViewModel;

public class IncenseDataUploadViewModel extends ViewModel {


    //get the image file type
    public String getExtension(Uri uri, Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

}