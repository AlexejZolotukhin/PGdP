public class BinarySearch {

    public static int binarySearch(int anArray[], int first, int last, int value) {
        int index;

        if (first > last) {
            index = -1;
        } else {
            int mid = (first + last) / 2;

            if(value == anArray[mid]) {
                index = mid;
            } else if(value < anArray[mid]) { //Point x
                index = binarySearch(anArray, first, mid - 1, value);
            } else { //Point Y
                index = binarySearch(anArray, mid + 1, last, value);
            }
        }

        return index;
    }

    public static int binarySearchIterative(int anArray[], int first, int last, int value) {

        do {
            if (first > last) {
                return -1;
            } else {
                int mid = (first + last) / 2;

                if(value == anArray[mid]) {
                    return mid;
                } else if(value < anArray[mid]) { //Point x
                    last = mid - 1;
                    //index = binarySearch(anArray, first, mid - 1, value);
                } else { //Point Y
                    first = mid + 1;
                    //index = binarySearch(anArray, mid + 1, last, value);
                }
            }
        }
        while(true);
    }

}
