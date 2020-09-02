package com.sanstwy27.designpattern.command.sample;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();

        System.out.println("==================");
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("---- light: turn on ----");
        remoteController.onButtonWasPushed(0);
        System.out.println("---- light: turn off ----");
        remoteController.offButtonWasPushed(0);
        System.out.println("---- light: undo ----");
        remoteController.undoButtonWasPushed();

        System.out.println("==================");
        TVReceiver tvReceiver = new TVReceiver();
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        System.out.println("---- TV: turn on ----");
        remoteController.onButtonWasPushed(1);
        System.out.println("---- TV: turn off ----");
        remoteController.offButtonWasPushed(1);
        System.out.println("---- TV: turn undo ----");
        remoteController.undoButtonWasPushed();

        /**
         * ==================
         * ---- light: turn on ----
         *  Light on..
         * ---- light: turn off ----
         *  Light off..
         * ---- light: undo ----
         *  Light on..
         * ==================
         * ---- TV: turn on ----
         *  TV on..
         * ---- TV: turn off ----
         *  TV off..
         * ---- TV: turn undo ----
         *  TV on..
         *
         */
    }
}
