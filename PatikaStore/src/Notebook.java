import java.util.HashSet;
import java.util.TreeSet;
import java.util.UUID;

public class Notebook implements Comparable<Notebook>{

    static TreeSet <Notebook> noteBooks = new TreeSet<>();
    private final UUID id = UUID.randomUUID();
    private final String realId = id.toString().substring(0,7);
    private int price,discountRate,stockAmount,memoryAmount,RAM;
    private final String name,notebookColor;
    private final Brand brandName;
    private final double screenSize;



    public Notebook(int price, int discountRate, int stockAmount, int memoryAmount, int RAM, String name, String notebookColor, Brand brandName, double screenSize) {
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.memoryAmount = memoryAmount;
        this.RAM = RAM;
        this.name = name;
        this.notebookColor = notebookColor;
        this.brandName = brandName;
        this.screenSize = screenSize;
    }

    static {
        noteBooks.add(new Notebook(4000,10,124,1000,32,"IBook","Black",new Brand("Apple"),15.2));
        noteBooks.add(new Notebook(5500,0,45,3000,64,"Fold","Red",new Brand("Apple"),21.4));
        noteBooks.add(new Notebook(2540,15,67,750,16,"TUF","Blue",new Brand("MSI"),16.7));
        noteBooks.add(new Notebook(3460,25,99,500,8,"Monster","Grey",new Brand("Xiaomi"),17.4));
    }

    public String getRealId() {
        return realId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getMemoryAmount() {
        return memoryAmount;
    }

    public int getRAM() {
        return RAM;
    }

    public String getName() {
        return name;
    }

    public String getNotebookColor() {
        return notebookColor;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public int compareTo(Notebook o) {
        return this.getBrandName().getBrandName().charAt(0) - o.getBrandName().getBrandName().charAt(0) ;
    }
}