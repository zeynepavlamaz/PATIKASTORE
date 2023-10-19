import java.util.Comparator;

// Bu sınıf, MobilePhone nesnelerini 'realId' adlı bir özelliğe göre karşılaştırmak için bir Comparator sınıfıdır.
public class IdOrderComparator implements Comparator<MobilePhone> {

    // Bu metot, iki MobilePhone nesnesini karşılaştırmak için kullanılır.
    @Override
    public int compare(MobilePhone o1, MobilePhone o2) {
        // 'o1' ve 'o2' parametreleri, karşılaştırılacak MobilePhone nesneleridir.

        // Karşılaştırma sonucunu belirlemek için 'realId' özelliğinin ilk karakterlerini karşılaştırırız.
        // 'realId' bir String olduğu için 'charAt(0)' metodu, ilk karakteri alır.
        // İki karşılaştırma sonucunu döndürür:
        //   - Negatif bir değer, 'o1' nesnesinin 'o2' nesnesinden önce gelmesi gerektiğini belirtir.
        //   - Pozitif bir değer, 'o2' nesnesinin 'o1' nesnesinden önce gelmesi gerektiğini belirtir.
        //   - 0, 'o1' ve 'o2' nesnelerinin aynı konumda olduğunu belirtir (aynı sırada).
        return o1.getRealId().charAt(0) - o2.getRealId().charAt(0);
    }
}


/* @Override

 compare metodunun Comparator arabirimini uyguladığını belirtir.
 compare metodu ise iki MobilePhone nesnesini karşılaştırmak için kullanılır ve sonuç olarak hangi
 nesnenin önde olması gerektiğini belirler.
*/