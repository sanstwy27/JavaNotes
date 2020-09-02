package com.sanstwy27.designpattern.command.sample;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class TVOffCommand implements Command {
    TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
