import java.util.UUID;
import java.util.TreeSet;

public class Brand implements Comparable<Brand>{
    static TreeSet<Brand> brands = new TreeSet<>();
    private final String brandName;
    private final UUID id = UUID.randomUUID();

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public UUID getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }


    @Override
    public int compareTo(Brand o) {
        return this.getBrandName().charAt(0) -  o.getBrandName().charAt(0);
    }

// Aşağıdaki statik blok, 'brands' kümesini başlatır.
    static {
        brands.add(new Brand("Samsung"));// Markalar ekleniyor.
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("Hp"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));


    }
}
