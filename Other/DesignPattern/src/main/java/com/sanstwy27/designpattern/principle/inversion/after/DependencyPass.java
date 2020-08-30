package com.sanstwy27.designpattern.principle.inversion.after;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class DependencyPass {
    public static void main(String[] args) {
        /**
         * Method 1, pass by interface
         */
        //AppleTV appleTV = new AppleTV();
		//OpenAndClose openAndClose = new OpenAndClose();
		//openAndClose.open(appleTV);

        /**
         * Method 2: pass by constructor
         */
        //AppleTV appleTV = new AppleTV();
		//OpenAndClose openAndClose = new OpenAndClose(appleTV);
		//openAndClose.open();

        /**
         * Method 3: pass by setter
         */
        AppleTV appleTV = new AppleTV();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(appleTV);
        openAndClose.open();
    }
}

/**
 * Method 1, pass by interface
 */
//interface IOpenAndClose {
//    public void open(ITV tv);
//}
//
//interface ITV {
//    public void play();
//}
//
//class AppleTV implements ITV {
//    @Override
//    public void play() {
//        // TODO Auto-generated method stub
//        System.out.println("AppleTV, opened");
//    }
//}
//
//class OpenAndClose implements IOpenAndClose {
//    public void open(ITV tv) {
//        tv.play();
//    }
//}


/**
 * Method 2: pass by constructor
 */
//interface IOpenAndClose {
//    public void open();
//}
//
//interface ITV {
//    public void play();
//}
//
//class AppleTV implements ITV {
//    @Override
//    public void play() {
//        // TODO Auto-generated method stub
//        System.out.println("AppleTV, opened");
//    }
//}
//
//class OpenAndClose implements IOpenAndClose {
//    public ITV tv;
//
//    public OpenAndClose(ITV tv) {
//        this.tv = tv;
//    }
//
//    public void open() {
//        this.tv.play();
//    }
//}

/**
 * Method 3: pass by setter
 */
interface IOpenAndClose {
    public void open();
    public void setTv(ITV tv);
}

interface ITV {
    public void play();
}

class OpenAndClose implements IOpenAndClose {
    private ITV tv;

    public void setTv(ITV tv) {
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}

class AppleTV implements ITV {
    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("AppleTV, opened");
    }
}





