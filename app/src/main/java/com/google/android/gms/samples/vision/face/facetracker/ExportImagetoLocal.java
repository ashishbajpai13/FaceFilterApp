package com.google.android.gms.samples.vision.face.facetracker;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Locale;

public class ExportImagetoLocal {

    public static void saveImage(Context context, Bitmap b) {
        try {
            File path = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            FileOutputStream fOut = null;
            Integer counter = 0;
            File file = new File(path, "Image" + counter + ".jpg");
            fOut = new FileOutputStream(file);
            b.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            fOut.flush();
            fOut.close();
            Toast.makeText(context,
                    context.getString(R.string.image_saved), Toast.LENGTH_SHORT).show();
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
