package interpreter;

import interpreter.bytecode.*;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    //setter for private int pc
    public void setpc(int mypc) {
        this.pc = mypc;
    }

    public void dumpOff() {
        this.isRunning = !this.isRunning;
    }

    public void switchDumpMode() {
        this.dump = !this.dump;
    }

    public String getDumpMode() {
        String dumpMode = " ";
        if (dump) {
            dumpMode = "ON";
        }
        
        if (!dump){
            dumpMode = "OFF";
        }
        return dumpMode;
    }
       
    //stack returnAddrs methods
    public void pushReturnAddrs() {
        this.returnAddrs.push(this.pc);
    }

    public void popReturnAddrs() {
        this.pc = this.returnAddrs.pop();
    }

    //RunTimeStack runStack methods
    public int peekRunStack() {
        return this.runStack.peek();
    }

    public void pushRunStack(int n) {
        runStack.push(n);
    }

    public int popRunStack() {
        return this.runStack.pop();
    }

    public void popAllRunStack() {
        this.runStack.popAll();
    }

    //runTimeStack runStack frame methods
    public void pushNewFrame(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popAllCurrentFrame() {
        this.runStack.popFrame();
    }

    public void storeAtOffset(int offset) {
        runStack.store(offset);
    }

    public void loadFromOffset(int offset) {
        runStack.load(offset);
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        dump = true;

        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);

            if (dump && !(DumpCode.class.isInstance(code))) {
                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }
    }
}
