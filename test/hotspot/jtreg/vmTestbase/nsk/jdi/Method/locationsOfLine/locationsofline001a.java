/*
 * Copyright (c) 2001, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package nsk.jdi.Method.locationsOfLine;

import nsk.share.*;
import nsk.share.jpda.*;
import nsk.share.jdi.*;


/**
 * This class is used as debuggee application for the locationsofline001 JDI test.
 */

public class locationsofline001a {

    //----------------------------------------------------- templete section

    static final int PASSED = 0;
    static final int FAILED = 2;
    static final int PASS_BASE = 95;

    //--------------------------------------------------   log procedures

    static boolean verbMode = false;

    private static void log1(String message) {
        if (verbMode)
            System.err.println("**> locationsofline001a: " + message);
    }

    private static void logErr(String message) {
        if (verbMode)
            System.err.println("!!**> locationsofline001a: " + message);
    }

    //====================================================== test program

    static TestClass obj = new TestClass();

    //----------------------------------------------------   main method

    public static void main (String argv[]) {

        for (int i=0; i<argv.length; i++) {
            if ( argv[i].equals("-vbs") || argv[i].equals("-verbose") ) {
                verbMode = true;
                break;
            }
        }
        log1("debuggee started!");

        // informing a debugger of readyness
        ArgumentHandler argHandler = new ArgumentHandler(argv);
        IOPipe pipe = argHandler.createDebugeeIOPipe();
        pipe.println("ready");


        int exitCode = PASSED;
        for (int i = 0; ; i++) {

            String instruction;

            log1("waiting for an instruction from the debugger ...");
            instruction = pipe.readln();
            if (instruction.equals("quit")) {
                log1("'quit' recieved");
                break ;

            } else if (instruction.equals("newcheck")) {
                switch (i) {

    //------------------------------------------------------  section tested

                case 0:
                                pipe.println("checkready");
                                break ;

    //-------------------------------------------------    standard end section

                default:
                                pipe.println("checkend");
                                break ;
                }

            } else {
                logErr("ERRROR: unexpected instruction: " + instruction);
                exitCode = FAILED;
                break ;
            }
        }

        System.exit(exitCode + PASS_BASE);
    }
}


class TestClass {

    public boolean bl () { return false; }
    public byte    bt () { return 0;     }
    public char    ch () { return 0;     }
    public double  db () { return 0.0d;  }
    public float   fl () { return 0.0f;  }
    public int     in () { return 0;     }
    public long    ln () { return 0;     }
    public short   sh () { return 0;     }

    public void vd () { return ; }



   public void primitiveargsmethod ( boolean bl,  byte bt ) {
       boolean bl1 = bl;
       byte    bt1 = bt;
       return ;
   }


/*
    private ClassForCheck_2 class2 = new ClassForCheck_2();

    private ClassForCheck classFC1 = new ClassForCheck();
    private InterfaceForCheck iface1 = class2;
    private ClassForCheck cfc1[] = { new ClassForCheck(), new ClassForCheck() };

    public ClassForCheck[] arrayargmethod (ClassForCheck cfc[]) {
        return cfc;
    }
    public ClassForCheck classargmethod (ClassForCheck classFC) {
        return classFC;
    }
    public InterfaceForCheck ifaceargmethod (InterfaceForCheck iface) {
        return iface;
    }

}


interface InterfaceForCheck {

    static final boolean s_iface_boolean = true;
    static final byte    s_iface_byte    = (byte)1;
    static final char    s_iface_char    = '1';
    static final double  s_iface_double  = 999;
    static final float   s_iface_float   = 99;
    static final int     s_iface_int     = 100;
    static final long    s_iface_long    = 1000;
    static final Object  s_iface_object  = new Object();
}

class ClassForCheck_2 implements InterfaceForCheck {
}

class ClassForCheck {

    static boolean bl[] = {true, false};

    static boolean   s_boolean;
    static byte      s_byte;
    static char      s_char;
    static double    s_double;
    static float     s_float;
    static int       s_int;
    static long      s_long;

    // instance fields

    boolean  i_boolean;
    byte     i_byte;
    char     i_char;
    double   i_double;
    float    i_float;
    int      i_int;
    long     i_long;
*/

}
