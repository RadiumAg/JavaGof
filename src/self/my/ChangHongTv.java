package self.my;

public class ChangHongTv implements  TV {
    @Override
    public void open() {
        System.out.println("打开长虹电视");
    }

    @Override
    public void close() {
        System.out.println("关闭长虹电视");
    }

    @Override
    public void autoClose() {
        System.out.println("自动关闭长虹电视");
    }
}
