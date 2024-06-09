package i222504_G_LAB11_task1.i222504_G_LAB11_task1;

public class Coffee {
    private String type;
    private String size;
    private double price;

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Coffee(String type, String size, double price) {
		super();
		this.type = type;
		this.size = size;
		this.price = price;
	}

	@Override
    public String toString() {
        return "Coffee{" +
               "type='" + type + '\'' +
               ", size='" + size + '\'' +
               ", price=" + price +
               '}';
    }
	public class Espresso extends Coffee {

		public Espresso(String type, String size, double price) {
			super(type, size, price);
		}

	}

	public class Latte extends Coffee {

		public Latte(String type, String size, double price) {
			super(type, size, price);
		}

	}

	
}
