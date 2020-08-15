package self.my;

public class Remote extends RemoteControll {
    public Remote(TV tv) {
        super(tv);
    }

    public void open() {
        this.tv.open();
    }

    public void close() {
        this.tv.close();
    }

    public void autClose() {
        this.tv.autoClose();
    }

}
