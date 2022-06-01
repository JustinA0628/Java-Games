package com.zzg.main;

import java.applet.Applet;
import java.applet.AudioClip;

public class Music {
	public void playSound(String file) {
		AudioClip sound = Applet.newAudioClip(getClass().getResource(file));
		sound.play();
	}
}
