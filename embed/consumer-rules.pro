# The JavaScript bridge is reached by name from the game page; keep it through R8.
-keepclassmembers class app.spinline.embed.SpinlineGameView$Bridge { @android.webkit.JavascriptInterface <methods>; }
