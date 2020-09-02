package com.sanstwy27.designpattern.command.sample;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class LightOffCommand implements Command {
    LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
