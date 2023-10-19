import java.util.Comparator;

// Bu sınıf, Notebook nesnelerini 'realId' adlı bir özelliğe göre karşılaştırmak için bir Comparator sınıfıdır.
public class IDOrderComparatorNoteBook implements Comparator<Notebook> {

    // Bu metot, iki Notebook nesnesini karşılaştırmak için kullanılır.
    @Override
    public int compare(Notebook o1, Notebook o2) {
        // 'o1' ve 'o2' parametreleri, karşılaştırılacak Notebook nesneleridir.

        // Karşılaştırma sonucunu belirlemek için 'realId' özelliğinin ilk karakterlerini karşılaştırırız.
        // 'realId' bir String olduğu için 'charAt(0)' metodu, ilk karakteri alır.
        // İki karşılaştırma sonucunu döndürür:
        //   - Negatif bir değer, 'o1' nesnesinin 'o2' nesnesinden önce gelmesi gerektiğini belirtir.
        //   - Pozitif bir değer, 'o2' nesnesinin 'o1' nesnesinden önce gelmesi gerektiğini belirtir.
        //   - 0, 'o1' ve 'o2' nesnelerinin aynı konumda olduğunu belirtir (aynı sırada).
        return o1.getRealId().charAt(0) - o2.getRealId().charAt(0);
    }
}
