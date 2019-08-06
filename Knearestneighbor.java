// The Machine Learning K Nearest Neighbor Algorithm
// By: Karen Proft
// October 23, 2018

package knearestneighbor;
import java.io.*;
import java.util.*;

public class Knearestneighbor {

    static List<List<Float>> irisData = new ArrayList<List<Float>>();
    static List<List<Float>> testData = new ArrayList<List<Float>>();

    public static void main(String[] args) throws Exception 
    { 
        System.out.println("Running K Nearest Neighbor Algorithm: ");
        //populate irisData samples
        readInFile();
        
        //populate testing examples
        populateTestData();
        
        System.out.println("\nThe Testing Samples are: ");
        printSamples(testData);
        
        //find the k nearest neighbor to a specific test sample and return an array of the NN's correct answers
        int k = 1;
        for(int i = 0; i < testData.size(); i++)
        { 
            System.out.println("\nGetting " + k + " KNN for test sample " + (i + 1) + "...");
            List<Float> testSample = testData.get(i);
            List<Integer> knnIndexes = findKNN(k, testSample);
            System.out.println("The KNN for test sample " + (i + 1) + " are: ");
            printKNN(knnIndexes);
            float answer = calcAnswer(testSample, knnIndexes);
            System.out.println("The estimated answer is: " + answer);
            if ((answer >= 0) && (answer < 1.5))
            {
                System.out.println("Thus the test sample is Iris-setosa");
            }
            else if ((answer >= 1.5) && (answer < 2.5))
            {
                System.out.println("Thus the test sample is Iris-versicolor");
            }
            else
            {
                System.out.println("Thus the test sample is Iris-virginica");
            }
        }
        
        k = 3;
        for(int i = 0; i < testData.size(); i++)
        { 
            System.out.println("\nGetting " + k + " KNN for test sample " + (i + 1) + "...");
            List<Float> testSample = testData.get(i);
            List<Integer> knnIndexes = findKNN(k, testSample);
            System.out.println("The KNN for test sample " + (i + 1) + " are: ");
            printKNN(knnIndexes);
            float answer = calcAnswer(testSample, knnIndexes);
            System.out.println("The estimated answer is: " + answer);
            if ((answer >= 0) && (answer < 1.5))
            {
                System.out.println("Thus the test sample is Iris-setosa");
            }
            else if ((answer >= 1.5) && (answer < 2.5))
            {
                System.out.println("Thus the test sample is Iris-versicolor");
            }
            else
            {
                System.out.println("Thus the test sample is Iris-virginica");
            }
        }
        
        k = 5;
        for(int i = 0; i < testData.size(); i++)
        { 
            System.out.println("\nGetting " + k + " KNN for test sample " + (i + 1) + "...");
            List<Float> testSample = testData.get(i);
            List<Integer> knnIndexes = findKNN(k, testSample);
            System.out.println("The KNN for test sample " + (i + 1) + " are: ");
            printKNN(knnIndexes);
            float answer = calcAnswer(testSample, knnIndexes);
            System.out.println("The estimated answer is: " + answer);
            if ((answer >= 0) && (answer < 1.5))
            {
                System.out.println("Thus the test sample is Iris-setosa");
            }
            else if ((answer >= 1.5) && (answer < 2.5))
            {
                System.out.println("Thus the test sample is Iris-versicolor");
            }
            else
            {
                System.out.println("Thus the test sample is Iris-virginica");
            }
        }
        
    }
    
    public static void printSamples(List<List<Float>> samples)throws Exception 
    {
        for (int i = 0; i < samples.size(); i++)
        {
            System.out.println(samples.get(i));
        }
    }
    
    public static void printKNN(List<Integer> knnIndex)throws Exception 
    {
        for (int i = 0; i < knnIndex.size(); i++)
        {
            System.out.println("Iris Sample at index " + knnIndex.get(i) + ": " + irisData.get(knnIndex.get(i)));
        }
    }
    
    
    public static float calcAnswer(List<Float> testSample, List<Integer> knnIndex)throws Exception 
    {
        //calculate the weight of each nearest neighbor
        List<Float> knnWeights = new ArrayList<Float>();
        
        float summOfAllKnnWeights = 0;
        for (int i = 0; i < knnIndex.size(); i++)
        {
            summOfAllKnnWeights += (1/calcDistance(testSample, irisData.get(knnIndex.get(i))));
        }
        
        for (int i = 0; i < knnIndex.size(); i++)
        {
            float knnWeight = (1/calcDistance(testSample, irisData.get(knnIndex.get(i))));
            knnWeight = knnWeight/summOfAllKnnWeights;
            knnWeights.add(knnWeight);
        }
        
        //calculate estimated answer/class
        float knnAnswer = 0;
        for(int i = 0; i < knnIndex.size(); i++)
        {
            knnAnswer += (knnWeights.get(i) * irisData.get(knnIndex.get(i)).get(4));
        }
        return knnAnswer;
    }
    
    //returns an arraylist of the k nearest neighbor's indexes
    public static List<Integer> findKNN(int k, List<Float> testSample)throws Exception 
    {
        List<Float> kMinDistances = new ArrayList<Float>(k);
        List<Integer> kMinIndexes = new ArrayList<Integer>(k);
        
        while(kMinIndexes.size() != k)
        {
            float minDistance = Float.MAX_VALUE;
            int minIndex = 0;
            
            for (int i = 0; i < irisData.size(); i++)
            {
                float currentDistance = calcDistance(testSample, irisData.get(i));
                
                if ((kMinIndexes.isEmpty()) && (currentDistance < minDistance))
                {
                    minDistance = currentDistance;
                    minIndex = i;
                }
                else if (!(kMinIndexes.contains(i)) && (currentDistance < minDistance))
                    {
                        minDistance = currentDistance;
                        minIndex = i;
                    }
            }
            kMinDistances.add(minDistance);
            kMinIndexes.add(minIndex); 
        }
        
        return kMinIndexes;
    }
    
    public static float calcDistance(List<Float> testSample, List<Float> irisSample)throws Exception 
    {
        //(sepalLength1 - sepalLength2)^2
        float x1 = testSample.get(0);
        float x2 = irisSample.get(0);
        float sepalLength = (float)(Math.pow(x1 - x2,2));
        //(sepalWidth1 - sepalWidth2)^2
        x1 = testSample.get(1);
        x2 = irisSample.get(1);
        float sepalWidth = (float)(Math.pow(x1 - x2,2));
        //(petalLength1 - petalLength2)^2
        x1 = testSample.get(2);
        x2 = irisSample.get(2);
        float petalLength = (float)(Math.pow(x1 - x2,2));
        //(petalWidth1 - petalWidth2)^2
        x1 = testSample.get(3);
        x2 = irisSample.get(3);
        float petalWidth = (float)(Math.pow(x1 - x2,2));
        //totalDistance
        float distance = (float) Math.sqrt(sepalLength + sepalWidth + petalLength + petalWidth);
        
        return distance;
    }
    
    public static void populateTestData()throws Exception 
    {
        
        //First test sample:
        float f1 = (float)4.9;
        float f2 = (float)3.0;
        float f3 = (float)1.4;
        float f4 = (float)0.2;
        float f5 = (float)0; //When the class is unbknown it = 0
        testData.add(new ArrayList<Float>());
        testData.get(0).add(f1);
        testData.get(0).add(f2);
        testData.get(0).add(f3);
        testData.get(0).add(f4);
        testData.get(0).add(f5);
        
        //Second test sample:
        f1 = (float)4.9;
        f2 = (float)2.4;
        f3 = (float)3.3;
        f4 = (float)1.0;
        testData.add(new ArrayList<Float>());
        testData.get(1).add(f1);
        testData.get(1).add(f2);
        testData.get(1).add(f3);
        testData.get(1).add(f4);
        testData.get(1).add(f5);
        
        //Third test sample:
        f1 = (float)4.9;
        f2 = (float)2.5;
        f3 = (float)4.5;
        f4 = (float)1.7;
        testData.add(new ArrayList<Float>());
        testData.get(2).add(f1);
        testData.get(2).add(f2);
        testData.get(2).add(f3);
        testData.get(2).add(f4);
        testData.get(2).add(f5);

    }
    
    public static void readInFile()throws Exception 
    {
        File file = new File("iris.txt"); 
        Scanner sc = new Scanner(file);
        
        int linesInFile = 0;
        while (sc.hasNextLine()) 
        {
            irisData.add(new ArrayList<Float>()); //add new row to the list
            
            String oneLineData = sc.nextLine();
            String[] splitLineData = oneLineData.split(",");

            for(int i = 0; i < 5; i++)
            {
                //for all the attribute data that is not a class string convert it to a float
                if((i != 4)) 
                {
                    float f = Float.parseFloat(splitLineData[i]);
                    irisData.get(linesInFile).add(f);
                }
                else
                {
                    //1 = Setosa, 2 = Versicolour, 3 = Virginica
                    switch (splitLineData[i])
                    {
                        case "Iris-setosa":
                            float f = 1;
                            irisData.get(linesInFile).add(f);
                            break;
                        case "Iris-versicolor":
                            f = 2;
                            irisData.get(linesInFile).add(f);
                            break;
                        case "Iris-virginica":
                            f = 3;
                            irisData.get(linesInFile).add(f);
                            break;
                        default:
                            break;
                    }   
                }
            }
            linesInFile++;
        }
        
    }
    
}
