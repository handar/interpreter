package interpreter.bytecode;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;
import java.util.HashMap;

public abstract class BopCode extends ByteCode {
    
    protected String binaryOp;
    private static final HashMap<String, BopCode> binaryOpMap;
    
    static {
        binaryOpMap = new HashMap<>();
        binaryOpMap.put("+", new BopAdd());
        binaryOpMap.put("-", new BopSubtract());
        binaryOpMap.put("*", new BopMultiply());
        binaryOpMap.put("/", new BopDivide());
        binaryOpMap.put("==", new BopEquals());
        binaryOpMap.put("!=", new BopNotEqual());
        binaryOpMap.put("<", new BopLessThan());
        binaryOpMap.put("<=", new BopLessThanEquals());
        binaryOpMap.put(">", new BopGreaterThan());
        binaryOpMap.put(">=", new BopGreaterThanOrEquals());
        binaryOpMap.put("|", new LogicalOr());
        binaryOpMap.put("&", new LogicalAnd());
    }   
    
    @Override
    public void init(String arg1, String arg2) {
        this.binaryOp = arg1;
    }
    
    @Override
    public String toString() {  
        String returnString = "BOP " + binaryOp;
        return returnString;
    }
    
    @Override
    public abstract void execute(VirtualMachine vm);
    
    public interface GetBop {
        default public BopCode getBop(String bop) {
            BopCode newBop = binaryOpMap.get(bop);
            return newBop;
        }
    }
}