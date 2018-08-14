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
public class LitCode extends ByteCode {

    int n;
   public String id = "";

    @Override
    public void init(Vector<String> args) {
        n = Integer.parseInt(args.firstElement());
        if (args.size() > 1) {
            id = args.get(args.size() - 1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.Push(n);
        String tmp = "LIT ";
        tmp = tmp.concat(((Integer) n).toString());
        if (!(id.isEmpty())) {//<------ if(!(id.equals("void")))

            tmp = tmp.concat(" " + id + "   int " + id);
        }
        vm.dump(tmp);
    
}

@Override
        public String getArgs() {
        return id;
    }

}
