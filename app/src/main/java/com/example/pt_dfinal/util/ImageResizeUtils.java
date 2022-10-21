package com.example.pt_dfinal.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageResizeUtils {
	
	/**
	 * 이미지의 너비를 변경한다.
	 * @param file
	 * @param newFile
	 * @param newWidth
	 */

	public static void resizeFile(File file, File newFile,int newWidth,Boolean isCamera) {

		String TAG = "blackjin";

		Bitmap originalBm = null;
		Bitmap resizedBitmap = null;
		
		try {

			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inPurgeable = true;
			options.inDither = true;

			originalBm = BitmapFactory.decodeFile(file.getAbsolutePath(), options);

			if(isCamera) {

				// 카메라인 경우 이미지를 상황에 맞게 회전시킨다
				try {

					ExifInterface exif = new ExifInterface(file.getAbsolutePath());
					int exifOrientation = exif.getAttributeInt(
							ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
					int exifDegree = exifOrientationToDegrees(exifOrientation);
					Log.d(TAG,"exifDegree : " + exifDegree);

					originalBm = rotate(originalBm, exifDegree);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			if(originalBm == null) {
				Log.e(TAG,("파일 에러"));
				return;
			}

			int width = originalBm.getWidth();
			int height = originalBm.getHeight();

			float aspect, scaleWidth, scaleHeight;
			if(width > height) {

				//if(width <= newWidth) return;

				aspect = (float) width / height;

				scaleWidth = newWidth;
				scaleHeight = scaleWidth/ aspect;

//				scaleHeight = newWidth;
//				scaleWidth = scaleHeight / aspect;



			} else {

				//if(height <= newWidth) return;

				aspect = (float) height / width;



				scaleWidth = newWidth;
				scaleHeight = scaleWidth/ aspect;




			}

			/*if(width <= newWidth) return;

			float aspect = (float) width / height;

			float scaleWidth = newWidth;
			float scaleHeight = scaleWidth / aspect;*/

			// create a matrix for the manipulation
			Matrix matrix = new Matrix();

			// resize the bitmap
			matrix.postScale(scaleWidth / width, scaleHeight / height);
//			matrix.postScale(scaleWidth / width*width, scaleHeight / height*height);



			// recreate the new Bitmap
			resizedBitmap = Bitmap.createBitmap(originalBm, 0, 0, width, height, matrix, true);
//
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

				resizedBitmap.compress(CompressFormat.JPEG, 80, new FileOutputStream(newFile));

			} else {

				resizedBitmap.compress(CompressFormat.PNG, 80, new FileOutputStream(newFile));

			}


		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} finally {

			if(originalBm != null){
				originalBm.recycle();
			}

			if (resizedBitmap != null){
				resizedBitmap.recycle();
			}
		}

	}

	/**
	 * EXIF 정보를 회전각도로 변환하는 메서드
	 *
	 * @param exifOrientation EXIF 회전각
	 * @return 실제 각도
	 */
	public static int exifOrientationToDegrees(int exifOrientation)
	{
		if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90)
		{
			return 90;
		}
		else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_180)
		{
			return 90;
		}
		else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_270)
		{
			return 90;
		}
		return 90;
	}

	/**
	 * 이미지를 회전시킵니다.
	 *
	 * @param bitmap 비트맵 이미지
	 * @param degrees 회전 각도
	 * @return 회전된 이미지
	 */
	public static Bitmap rotate(Bitmap bitmap, int degrees)
	{
		if(degrees != 0 && bitmap != null)
		{
			Matrix m = new Matrix();
			m.setRotate(degrees, (float) bitmap.getWidth() ,
					(float) bitmap.getHeight());

			try
			{
				Bitmap converted = Bitmap.createBitmap(bitmap, 0, 0,
						bitmap.getWidth(), bitmap.getHeight(), m, true);
				if(bitmap != converted)
				{
					bitmap.recycle();
					bitmap = converted;
				}
			}
			catch(OutOfMemoryError ex)
			{
				// 메모리가 부족하여 회전을 시키지 못할 경우 그냥 원본을 반환합니다.
			}
		}
		return bitmap;
	}
}
