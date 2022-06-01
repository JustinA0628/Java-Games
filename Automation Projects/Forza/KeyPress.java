package com.fh.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.mc.main.JNativeHook;

public class KeyPress implements NativeKeyListener{
	public void pressW(boolean a) throws AWTException {
		Robot bot = new Robot();
		if (a) {
			bot.keyPress(KeyEvent.VK_W);
		} else {
			bot.keyRelease(KeyEvent.VK_W);
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == NativeKeyEvent.VC_ALT_L) {
			ForzaGrindGui.isOn=!ForzaGrindGui.isOn;
			System.out.println(ForzaGrindGui.isOn);
			if (ForzaGrindGui.isOn) {
				try {
					pressW(true);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					pressW(true);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void run() {
		GlobalScreen.addNativeKeyListener(new KeyPress());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			
	

		
		}
		
		
	}
	public static void main(String[] args) {
		run();
	}
}
