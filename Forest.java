import java.io.*;
import java.text.DecimalFormat;

public class Forest implements Serializable {
    String ForestName;
    final int ForestSize = 10;
    Tree[] Trees = new Tree[ForestSize];
    Forest(String ForestName) {
        this.ForestName = ForestName;
        for (int i = 0; i < ForestSize; i++) Trees[i] = new Tree();
    }
    void displayForest() {
        DecimalFormat df = new DecimalFormat("#.##");
        int count = 1;
        System.out.println(ForestName);
        for (Tree aTree : Trees) {
            System.out.println(count + " :  " + df.format(aTree.getHeight()) + " (" + aTree.getGrowthRate() + "% pa)");
            count++;
        }
    }

    void simGrowthOfForest() {
        for(Tree aTree: Trees) {
            aTree.simTreeGrowth();
        }
    }

    void reapForest(int cutHeight) {
        DecimalFormat df = new DecimalFormat("#.##");
        int count = 1;
        for (Tree aTree: Trees) {
            if (aTree.getHeight() > cutHeight) {
                System.out.println("Cut " + count + " :  " + df.format(aTree.getHeight()) + " (" + aTree.getGrowthRate() + "% pa)");
                aTree.reapTree(cutHeight);
                System.out.println("New " + count + " :  " + df.format(aTree.getHeight()) + " (" + aTree.getGrowthRate() + "% pa)");
                count++;
            }
        }
    }

    void saveForest() {
        try {
            FileOutputStream fOut = new FileOutputStream(ForestName.toLowerCase() + ".forest");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(this);
            out.close();
            fOut.close();
            System.out.println("Forest saved in " + ForestName.toLowerCase() + ".forest");
        }catch(IOException i) {
            //i.printStackTrace();
            System.out.println("Unable to save forest");
        }
    }
    static Forest loadForest(String forestName, Forest f) {
        try {
            FileInputStream fIn = new FileInputStream(forestName.toLowerCase() + ".forest");
            ObjectInputStream in = new ObjectInputStream(fIn);
            Forest loadedForest = (Forest) in.readObject();
            in.close();
            fIn.close();
            return loadedForest;
        }
        catch (IOException i) {
            //i.printStackTrace();
            System.out.println("Forest file not found");
            return f;
        }catch(ClassNotFoundException c) {
            System.out.println("Forest class not found");
            //c.printStackTrace();
            return f;
        }
    }


}
