import java.io.Serializable;
import java.util.Random;

public class Tree implements Serializable {
    double height;
    int growthRate;
    Tree() {
        Random rand = new Random();
        this.height = 1 + 4 * rand.nextDouble();
        this.growthRate = 50 + rand.nextInt(50);;
    }
    double getHeight() {
        return height;
    }
    int getGrowthRate() {
        return growthRate;
    }
    void reapTree(int cutHeight) {
        height -= cutHeight;
    }
    void simTreeGrowth() {
        height += (((float)growthRate)/ 100) * height;
    }

}
