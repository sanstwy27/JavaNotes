package com.sanstwy27.designpattern.command.sample;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class LightOnCommand implements Command {
    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
