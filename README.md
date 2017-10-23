# Here's how to integrate the Dynamic Font SDK

### Step 1
#### Add jitpack.io maven repository:
Add the following to the root gradle file.

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

### Step 2
#### Add  Library as a gradle dependency
        compile 'com.github.dondaldo:DynamicFonts:0.0.4'

### Step 3
 
 	String fonturl = "FONT_URL";
        FontConfig.with(this).loadFont(fonturl, new Callback<Typeface>() {
            @Override
            public void send(Typeface typeface) {
                mTypeface = typeface;
		...
            }
        });
