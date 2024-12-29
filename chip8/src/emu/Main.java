package emu;

import chip.Chip;


public class Main extends Thread {
	
	private Chip chip8;
	private ChipFrame frame;
	
		
	public Main() {
		chip8 = new Chip();
		chip8.intialize();
		//chip8.run(); this one uses cli
		chip8.loadProgram("./wellcreateitlater");
		frame = new ChipFrame(chip8);		
	}
	
	public void run() {
		//60fps
		while(true) {
			chip8.run();
			if(chip8.needsRedraw()) {
				frame.repaint();
				chip8.removeDrawFlag();
			}
			Thread.sleep(16);
		}
	}
	
	
	public static void main (String[] args) {
		Main main = new Main();
		main.start();
	}
	
}
