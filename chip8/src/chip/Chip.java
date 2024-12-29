package chip;

public class Chip {
	
	private char[] memory;
	private int pc;//the program counter is simply the memory pointer
	
	
	private char[] v;
	private char I;
	
	private char[] stack;
	private int stackpt;
	
	private int delay_timer;//dont have exactly type and size in docs
	private int sound_timer;//same
	
	private byte[] keys;//input
	private byte[] display;
	
	public void intialize() {
		memory = new char[4096];//1024 * 4(4kb)
		v = new char [16];//16 general purpose registers Vx.
		I = 0x0; 
		
		pc = 0x200;//this is the org
		stack = new char[16];//The stack is an array of 16 16-bit values
		stackpt = 0;//stack pointer can be 8-bit initialized by 0
		
		delay_timer = 0 ;
		sound_timer = 0 ;
		
		keys = new byte[16];//the input keys are the hexadecimal digits
		
		display = new byte[2048];//64*32 The original implementation of the Chip-8 language used a 64x32-pixel
		//display[0]= 1;
		//display[5]= 1;
		//display[96]= 1;
		//just to see some white pixels
	}
	
	public void run() {
		//we have three steps
		//fetch the operation code
		char opcode = (char)((memory[pc] << 8) | memory[pc+1]);
		System.out.print(Integer.toHexString(opcode) + ": ");
		//System.out.println(Integer.toHexString(opcode));
		//decode the operation code
		
		switch(opcode & 0xF000) {//checking the first nibble
			
		case 0x8000:
			switch(opcode & 0x000F) {//checking the last nibble
			case 0x0000://in this case we are at 8XY0 means Vx := Vy
				default:
					System.err.println("Unsupported OPcode");
					System.exit(opcode);
					break;
					
			}
			
		
			default:
				System.err.println("Unsupported OPcode");
				System.exit(opcode);
		};
		//execute the operation code
		//the  wikipedia page defines how each operation is defined
		
	}
	public byte[] getDisplay() {
		return display;
	}
}
