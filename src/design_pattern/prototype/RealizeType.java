package design_pattern.prototype;

/**
 * 浅克隆原型模式.
 *
 * @author LiuYJ
 * @since 2019/4/4
 */
public class RealizeType implements Cloneable {
    private String type;

    private RealizeType() {
        type = "ProtoType";
        System.out.println("Prototype created.");
    }

    public RealizeType clone() throws CloneNotSupportedException {
        System.out.println("ProtoType: " + type);
        System.out.println("Clone prototype.");
        return (RealizeType) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType proto = new RealizeType();
        RealizeType clone = proto.clone();
        System.out.println("Clone: " + clone.type);
        System.out.println(proto == clone);
    }
}
