package senailist.algorithms.ordination;

public class BubbleSort {

    public Integer[] sort(Integer[] list) {
        for (int i = list.length - 1; i >= 1; i--) {
            boolean hasSwitch = false;
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    int aux = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = aux;
                    hasSwitch = true;
                }
            }
            if (!hasSwitch) {
                return list;
            }
        }
        return list;
    }

}
