package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        Iterator itr = framePointer.iterator();
        int nextFrame;
        int currentFrame;

        currentFrame = (int) itr.next();

        int framePointerSize = framePointer.size(); //get size of framePointer
        int runTimeStackSize = runTimeStack.size();

        //go through the runtime stack and dump it
        for (int i = 0; i < framePointerSize; i++) {
            //if stack has next element
            if (itr.hasNext()) {
                nextFrame = (int) itr.next(); //then the next framing = to value of itr.next()
            } else { //however, if there is no next element in frame then nextFrame = size of runTimeStack
                nextFrame = runTimeStackSize;
            }

            System.out.print("[");

            //frame the currentFrame - nextFrame
            for (int c = currentFrame; c < nextFrame; c++) {
                System.out.print(runTimeStack.get(c));
                if (c != nextFrame - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println();
    }

    public int peek() {
        //check if stack isn't empty
        if (!(runTimeStack.isEmpty())) { //if stack isn't empty, then proceed
            return runTimeStack.get(runTimeStack.size() - 1);
        } else {
            return 0;
        }
    }

    public int pop() {
        if (!(runTimeStack.isEmpty())) {
            int lastIndex = runTimeStack.size() - 1;
            int topElement = runTimeStack.get(lastIndex);
            runTimeStack.remove(lastIndex);
            return topElement;
        } else {
            return 0;
        }
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void popAll() {
        runTimeStack.clear();
    }

    //check for offset 
    @SuppressWarnings("empty-statement")
    public void newFrameAt(int offset) {
        int frameSize = runTimeStack.size();

        //if frameSize is less than the offset, then frame cannot be made!
        if (frameSize < offset) {
            ;
        } else {
            framePointer.add(frameSize - offset);
        }
    }
    
    public void popFrame() {
        int saveValue = this.peek();
        int popValue = framePointer.pop();
        for (int i = runTimeStack.size() - 1; i >= popValue; i--) {
            this.pop();
        }

        this.push(saveValue);

    }

    public int store(int offset) {
        int temp = this.pop();
        runTimeStack.set(framePointer.peek() + offset, temp);
        return temp;
    }

    public int load(int offset) {
        int temp = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(temp);
        return temp;
    }

    public Integer push(Integer i) {
        return i;
    }
}
