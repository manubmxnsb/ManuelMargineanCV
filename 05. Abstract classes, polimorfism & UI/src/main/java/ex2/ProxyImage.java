package ex2;

public class ProxyImage implements Image {

    private Image Image;
    private String fileName;
    private boolean type;

    public ProxyImage(String fileName, boolean type) {
        this.fileName = fileName;
        this.type = type;
    }

    @Override
    public void display() {
        if (type) {
            Image = new RealImage(fileName);
        } else {
            Image = new RotatedImage(fileName);
        }
        Image.display();
    }
}
