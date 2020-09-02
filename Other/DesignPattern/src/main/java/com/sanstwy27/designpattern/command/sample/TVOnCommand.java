package com.sanstwy27.designpattern.command.sample;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class TVOnCommand implements Command {
    TVReceiver tv;

    public TVOnCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
