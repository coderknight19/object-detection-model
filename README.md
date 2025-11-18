# Object Detection Model

This project implements a real-time **Object Detection Android App** using **TensorFlow Lite** and **OpenCV** in **Java**. The app loads a custom-trained TFLite model and detects objects from the live camera feed with bounding boxes and labels.

## Features
- Real-time object detection  
- TensorFlow Lite model (GPU optimized)  
- Bounding box drawing  
- Java + OpenCV integration  
- Works fully on-device  

## How to Use
1. Open the project in **Android Studio**  
2. Place your `model.tflite` and `labels.txt` inside:  
   app/src/main/assets/
3. Connect your Android phone  
4. Run the app  

## Requirements
- Android Studio  
- TensorFlow Lite  
- OpenCV Android SDK  
- Java (Android)

## Output
The app detects objects live and displays bounding boxes, labels, and confidence scores on the camera preview.
