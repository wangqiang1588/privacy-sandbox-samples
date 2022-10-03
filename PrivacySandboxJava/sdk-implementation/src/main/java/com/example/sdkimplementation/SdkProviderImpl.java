/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sdkimplementation;

import android.annotation.SuppressLint;
import android.app.sdksandbox.SandboxedSdk;
import android.app.sdksandbox.SandboxedSdkProvider;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;

/*
 * This class works as an entry point for the sandbox to interact with the SDK.
 *
 * This class should be populated inside the AndroidManifest file.
 */
@SuppressLint("NewApi")
public class SdkProviderImpl extends SandboxedSdkProvider {

  @SuppressLint("Override")
  @Override
  public SandboxedSdk onLoadSdk(Bundle params) {
    return new SandboxedSdk(new SdkApi(getContext()));
  }

  @SuppressLint("Override")
  @Override
  public View getView(Context windowContext, Bundle bundle, int width, int height) {
    WebView webView = new WebView(windowContext);
    webView.loadUrl("https://google.com");
    return webView;
  }

  /**
   * @deprecated Please use your APIs instead
   */
  @Override
  public void onDataReceived(
          @NonNull Bundle bundle, @NonNull DataReceivedCallback dataReceivedCallback) {
  }
}
