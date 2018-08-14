/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.Vector;

/**
 *
 * @author Bradley SomathiNg
 */
public class LabelCode extends ByteCode {

    private String label;

    @Override
    public void init(Vector<String> args) {
        label = (String) args.firstElement();
    }

    @Override
    public void execute(VirtualMachine vm) {
        String dumpString = "LABEL ";
        dumpString = dumpString.concat(label);
       // vm.dump(dumpString);
    }

    public String getArgs() {
        return label;
    }
}
