package com.example.yuri;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class Prefs extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// This line below is something you have to add!!
		// PrefsFragment is a class name i came up with, which is then referred
		// to below.
		// Might get an error until you finish the whole code
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new PrefsFragment()).commit();

	}

	// NEW CLASS, similar to above, BELOW! (This is still on the same Prefs.java
	// class page, don't create a new class!
	// This new class below is called an Internal Fragment Class
	// So the whole thing we accomplish here is we move the deprecated
	// addPreferencesFromResource() method
	// into this Internal Fragment class (below) then we call/invoke the
	// fragment(what you see below) from this activity (specifically from the
	// class above).
	// That whole getFragmentManager.... blah is just calling what's below, and
	// what's below is just doing what Travis is teaching
	// Why does it have to be separated to two steps, one step calling a
	// fragment? I don't know. lol

	public static class PrefsFragment extends PreferenceFragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			// Original line below
			addPreferencesFromResource(R.xml.prefs);
		}

	}

}