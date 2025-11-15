
package com.example.objectdetection;

import android.content.Context;
import android.graphics.Bitmap;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.gpu.GpuDelegate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Detector {

    private Interpreter interpreter;
    private GpuDelegate gpuDelegate;

    public Detector(Context context) {
        try {
            gpuDelegate = new GpuDelegate();
            Interpreter.Options options = new Interpreter.Options().addDelegate(gpuDelegate);
            interpreter = new Interpreter(loadModel(context), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MappedByteBuffer loadModel(Context context) throws IOException {
        FileInputStream fis = new FileInputStream(context.getAssets().openFd("model.tflite").getFileDescriptor());
        FileChannel channel = fis.getChannel();
        long startOffset = context.getAssets().openFd("model.tflite").getStartOffset();
        long length = context.getAssets().openFd("model.tflite").getDeclaredLength();
        return channel.map(FileChannel.MapMode.READ_ONLY, startOffset, length);
    }

    public String detect(Bitmap bitmap) {
        float[][] output = new float[1][1];
        interpreter.run(bitmap, output);
        return "Result: " + output[0][0];
    }
}
