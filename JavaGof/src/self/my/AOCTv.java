package self.my;

public class AOCTv implements TV {
    @Override
    public void open() {
        System.out.println("打开AOC电视");
    }

    @Override
    public void close() {
        System.out.println("关闭AOC电视");
    }

    @Override
    public void autoClose() {
        System.out.println("自动关闭AOC电视");
    }
}
