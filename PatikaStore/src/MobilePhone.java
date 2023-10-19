import java.util.TreeSet;
import java.util.UUID;

public class MobilePhone implements Comparable<MobilePhone> {
    static TreeSet<MobilePhone> mobilePhones = new TreeSet<>();

    private final UUID id = UUID.randomUUID();
    private final String realId = id.toString().substring(0,7);
    private int price,stockAmount,discountRate,memoryAmount,batteryMAH,RAM;
    private String name,phoneColor;
    private Brand brandName;
    private double screenSize;


    public MobilePhone(int price, int discountRate, int stockAmount, int memoryAmount, int batteryMAH, int RAM, String name,double screenSize, String phoneColor,Brand brandName) {
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.memoryAmount = memoryAmount;
        this.batteryMAH = batteryMAH;
        this.RAM = RAM;
        this.name = name;
        this.screenSize = screenSize;
        this.phoneColor = phoneColor;
        this.brandName = brandName;


    }

    static {
        mobilePhones.add(new MobilePhone(2500,15,190,128,5000,6,"YouPhone", 6.1,"Black",Brand.brands.first()));
        mobilePhones.add(new MobilePhone(3000,5,50,256,9000,6,"IPhone", 7.1,"Red",new Brand("Samsung")));
        mobilePhones.add(new MobilePhone(2120,20,80,64,6000,6,"WePhone", 5.1,"Blue",new Brand("Apple")));
        mobilePhones.add(new MobilePhone(1650,7,350,32,4000,6,"TheyPhone", 4.1,"Yellow",new Brand("Xiaomi")));
    }

    public String getRealId() {
        return realId;
    }

    public UUID getId() {
        return id;
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

    public void setMemoryAmount(int memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public int getBatteryMAH() {
        return batteryMAH;
    }

    public void setBatteryMAH(int batteryMAH) {
        this.batteryMAH = batteryMAH;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(String phoneColor) {
        this.phoneColor = phoneColor;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    // Marka A-Z Sıralama
    @Override
    public int compareTo(MobilePhone o) {
        return this.getBrandName().getBrandName().charAt(0) - o.getBrandName().getBrandName().charAt(0) ;
    }
}