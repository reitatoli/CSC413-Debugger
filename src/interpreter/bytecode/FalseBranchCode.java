/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.*;

/**
 *
 * @author Bradley SomathiNg
 */
public class FalseBranchCode extends ByteCode {

    private String label;
    int address;

    public void setAddress(int i) {
        address = i;
    }

    public int getAddress(){
        return address;
    }
    public void init(Vector<String> args) {
        label = (String) args.firstElement();
    }

    @Override
    public void execute(VirtualMachine vm) {
        int i = vm.pop();
        if (i == 0) {
            vm.setPC(address);
        }
    }

    @Override
    public String getArgs() {
return label;    }
}
