// IScreenshotProvider.aidl
package com.example.admin.newapplication;

// Declare any non-default types here with import statements

interface IScreenshotProvider {
	// Checks whether the native background application is running
	// (and thus whether the screenshots are available)
	boolean isAvailable();

	// Create a screen snapshot and returns path to file where it is written.
	String takeScreenshot();
}
