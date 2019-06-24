package interpreter.bytecode;

public abstract class JumpCode extends ByteCode {
    
    protected String label;
    protected int jumpIndex;
    
    @Override
    public void init(String arg1, String arg2) {
        this.label = arg1;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public void setJumpIndex(int n) {
        this.jumpIndex = n;
    }
    
}