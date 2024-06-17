public class Tuple {
    private boolean isExist;
    private int index;
    public Tuple(boolean isExist, int index) {
        this.isExist = isExist;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
